class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        long[][] dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(costs, k, candidates, 0, dp);
    }
    
    private long dfs(int[] costs, int k, int candidates, int start, long[][] dp) {
        if (k == 0) {
            return 0;
        }
        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        int n = costs.length;
        long ans = Long.MAX_VALUE;
        for (int i = start; i < n; i++) {
            if (i - start + 1 > candidates) {
                break;
            }
            ans = Math.min(ans, costs[i] + dfs(costs, k - 1, candidates, i + 1, dp));
        }
        return dp[start][k] = ans;
    }
}