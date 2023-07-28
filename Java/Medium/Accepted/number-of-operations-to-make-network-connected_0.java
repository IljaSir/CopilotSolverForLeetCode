class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            while (u != parent[u]) {
                u = parent[u];
            }
            while (v != parent[v]) {
                v = parent[v];
            }
            if (u != v) {
                parent[u] = v;
                n--;
            }
        }
        return n - 1;
    }
}