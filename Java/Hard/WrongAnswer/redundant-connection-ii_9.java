class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] ans = new int[2];
        int[] parent = new int[n+1];
        int[] size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != v) {
                ans[0] = u;
                ans[1] = v;
            } else {
                parent[v] = u;
            }
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if (u == ans[0] && v == ans[1]) {
                continue;
            }
            if (!union(u, v, parent, size)) {
                return edge;
            }
        }
        return ans;
    }
    
    private boolean union(int u, int v, int[] parent, int[] size) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if (pu == pv) {
            return false;
        }
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
    
    private int find(int u, int[] parent) {
        while (u != parent[u]) {
            u = parent[u];
        }
        return u;
    }
}