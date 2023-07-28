class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(i, k -> new HashSet<>()).add(i);
        }
        for (int[] swap : allowedSwaps) {
            int i = swap[0];
            int j = swap[1];
            if (map.get(i) != map.get(j)) {
                Set<Integer> a = map.get(i);
                Set<Integer> b = map.get(j);
                if (a.size() < b.size()) {
                    a.addAll(b);
                    for (int k : b) {
                        map.put(k, a);
                    }
                } else {
                    b.addAll(a);
                    for (int k : a) {
                        map.put(k, b);
                    }
                }
            }
        }
        int res = 0;
        for (Set<Integer> set : map.values()) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int i : set) {
                count.put(source[i], count.getOrDefault(source[i], 0) + 1);
            }
            for (int i : set) {
                int k = target[i];
                if (count.getOrDefault(k, 0) == 0) {
                    res++;
                } else {
                    count.put(k, count.get(k) - 1);
                }
            }
        }
        return res;
    }
}