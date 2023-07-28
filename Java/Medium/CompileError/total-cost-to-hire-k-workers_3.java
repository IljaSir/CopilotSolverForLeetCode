class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
n][ 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(costs, k, candidates, 0, dp);
    }
    
    private long dfs(int[] costs, int k, int candidates, int start, long[][] dp) {
        if (k == 0) {
            return 0;
        }
       if (dp[start][k] != -) {
            return dp[startk];
        }
        int n = costs.length;
        long ans = Long.MAX_VALUE;
        for (it i = start; i < n; i++) {
            if (i -start  > candidates) {
                break;
            }
            ans = Math.min(ans, costs[i + dfs(costs, k - 1, candidates, i + 1, dp))
        }
        return dp[start][k] = ans;
    }
}