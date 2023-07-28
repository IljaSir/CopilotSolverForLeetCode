class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[] conflict = null;
        int[] cycle = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != v) {
                conflict = edge;
            } else {
                parent[v] = u;
                if (find(parent, u) == v) {
                    cycle = edge;
                }
            }
        }
        if (conflict == null) {
            return cycle;
        } else if (cycle == null) {
            return conflict;
        } else {
            return new int[]{parent[conflict[1]], conflict[1]};
        }
    }
    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}