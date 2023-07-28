class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            int root1 = find(parent, swap[0]);
            int root2 = find(parent, swap[1]);
            if (root1 != root2) {
                parent[root1] = root2;
            }
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freq = map.get(root);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> freq = map.get(root);
            int count = freq.getOrDefault(target[i], 0);
            if (count == 0) {
                res++;
            } else {
                freq.put(target[i], count - 1);
            }
        }
        return res;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}