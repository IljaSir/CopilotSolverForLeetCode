class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            int root1 = find(root, swap[0]);
            int root2 = find(root, swap[1]);
            root[root1] = root2;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root1 = find(root, i);
            if (!map.containsKey(root1)) {
                map.put(root1, new HashMap<>());
            }
            Map<Integer, Integer> freq = map.get(root1);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int root1 = find(root, i);
            Map<Integer, Integer> freq = map.get(root1);
            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                res++;
            }
        }
        return res;
    }

    private int find(int[] root, int i) {
        if (root[i] == i) {
            return i;
        }
        return root[i] = find(root, root[i]);
    }
}