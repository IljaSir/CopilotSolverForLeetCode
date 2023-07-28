class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int mod = 1000000007;
        int n = vals.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(vals, edges, 0, i, dp);
            ans %= mod;
        }
        return ans;
    }

    public int dfs(int[] vals, int[][] edges, int start, int end, int[][] dp) {
        if (vals[start] < vals[end]) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start == end) {
            return 1;
        }
        int ans = 0;
        for (int[] edge : edges) {
            if (edge[0] == start) {
                ans += dfs(vals, edges, edge[1], end, dp);
                ans %= 1000000007;
            }
            if (edge[1] == start) {
                ans += dfs(vals, edges, edge[0], end, dp);
                ans %= 1000000007;
            }
        }
        dp[start][end] = ans;
        return ans;
    }
}