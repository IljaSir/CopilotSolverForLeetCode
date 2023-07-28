class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candA = null, candB = null;
        for (int[] edge : edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                candA = new int[] { parent[edge[1]], edge[1] };
                candB = new int[] { edge[0], edge[1] };
                edge[1] = 0;
            }
        }
        for (int i = 0; i <= n; ++i) parent[i] = i;
        for (int[] edge : edges) {
            if (edge[1] == 0) continue;
            int u = edge[0], v = edge[1], pu = find(parent, u), pv = find(parent, v);
            if (pu == pv) {
                if (candA == null) return edge;
                return candA;
            }
            parent[pv] = pu;
        }
        return candB;
    }
}