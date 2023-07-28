class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int fa = find(parent, edge[0]);
            int fb = find(parent, edge[1]);
            if (fa == fb) {
                return edge;
            }
            parent[fa] = fb;
        }
        return new int[0];
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}