class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(parent, rank, edge[0], edge[1]);
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[find(parent, i)]++;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) count[i] * (n - count[i] - 1);
        }
        return res / 2;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int[] rank, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
}