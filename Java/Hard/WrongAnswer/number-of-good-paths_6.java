class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        int mod = 1000000007;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dfs(vals, adj, dp, i, i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dp[i][j]) % mod;
            }
        }
        return (int) ans;
    }

    private void dfs(int[] vals, List<Integer>[] adj, long[][] dp, int u, int p) {
        int mod = 1000000007;
        for (int v : adj[u]) {
            if (v != p && vals[v] >= vals[u]) {
                dp[u][v] = (dp[u][v] + dp[u][p]) % mod;
                dfs(vals, adj, dp, v, u);
            }
        }
    }
}