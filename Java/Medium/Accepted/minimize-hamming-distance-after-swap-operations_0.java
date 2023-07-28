class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            map.putIfAbsent(p, new HashMap<>());
            map.get(p).put(source[i], map.get(p).getOrDefault(source[i], 0) + 1);
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            int count = map.get(p).getOrDefault(target[i], 0);
            if (count > 0) {
                res--;
                map.get(p).put(target[i], count - 1);
            }
        }
        return res;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    private void union(int[] parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        if (pi != pj) {
            parent[pi] = pj;
        }
    }
}