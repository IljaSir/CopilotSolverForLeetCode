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
            Map<Integer, Integer> count = map.getOrDefault(p, new HashMap<>());
            count.put(source[i], count.getOrDefault(source[i], 0) + 1);
            map.put(p, count);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            Map<Integer, Integer> count = map.get(p);
            int c = count.getOrDefault(target[i], 0);
            if (c > 0) {
                count.put(target[i], c - 1);
            } else {
                result++;
            }
        }
        return result;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
}