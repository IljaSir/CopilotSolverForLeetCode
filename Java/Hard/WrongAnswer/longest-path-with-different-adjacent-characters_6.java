class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        int[] adj[] = new int[n][];
        int[] deg = new int[n];
        for (int i = 0; i < n; i++) {
            deg[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] >= 0) {
                deg[parent[i]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            adj[i] = new int[deg[i]];
            deg[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] >= 0) {
                adj[parent[i]][deg[parent[i]]++] = i;
            }
        }
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dfs(0, adj, s, dp, dp2);
        return dp[0];
    }
    private void dfs(int u, int[][] adj, String s, int[] dp, int[] dp2) {
        dp[u] = 0;
        dp2[u] = 0;
        for (int v : adj[u]) {
            dfs(v, adj, s, dp, dp2);
            if (s.charAt(u) == s.charAt(v)) {
                dp2[u] = Math.max(dp2[u], dp2[v] + 1);
            } else {
                dp[u] = Math.max(dp[u], dp[v] + 1);
            }
        }
        dp[u] = Math.max(dp[u], dp2[u]);
    }
}