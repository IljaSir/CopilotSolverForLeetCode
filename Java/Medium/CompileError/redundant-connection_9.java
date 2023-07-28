class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (find(parent, x) != find(parent, y)) {
                union(parent, x, y);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}