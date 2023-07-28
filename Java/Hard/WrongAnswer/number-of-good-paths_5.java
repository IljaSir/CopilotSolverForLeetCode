class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int mod = 1000000007;
        int n = vals.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, vals, g, dp, mod);
    }
    private int dfs(int u, int[] vals, List<Integer>[] g, int[][] dp, int mod) {
        int n = vals.length;
        if (dp[u][u] != -1) return dp[u][u];
        int ans = 1;
        for (int v : g[u]) {
            if (vals[v] >= vals[u]) continue;
            ans += dfs(v, vals, g, dp, mod);
            ans %= mod;
        }
        return dp[u][u] = ans;
    }
}