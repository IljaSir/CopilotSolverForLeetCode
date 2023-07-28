class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(parent, u, v);
        }
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[find(parent, i)]++;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (size[i] > 1) {
                ans += (long) size[i] * (size[i] - 1) / 2;
            }
        }
        return (long) n * (n - 1) / 2 - ans;
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