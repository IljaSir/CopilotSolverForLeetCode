class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = dfs(houses, cost, m, n, target, 0, 0, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int[] houses, int[][] cost, int m, int n, int target, int cur, int preColor, int preGroup, int[][][] dp) {
        if (cur == m) {
            return preGroup == target ? 0 : Integer.MAX_VALUE;
        }
        if (dp[cur][preColor][preGroup] != -1) {
            return dp[cur][preColor][preGroup];
        }
        int ans = Integer.MAX_VALUE;
        if (houses[cur] != 0) {
            if (houses[cur] - 1 == preColor) {
                ans = dfs(houses, cost, m, n, target, cur + 1, preColor, preGroup, dp);
            } else {
                ans = dfs(houses, cost, m, n, target, cur + 1, houses[cur] - 1, preGroup + 1, dp);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i == preColor) {
                    ans = Math.min(ans, dfs(houses, cost, m, n, target, cur + 1, preColor, preGroup, dp) + cost[cur][i]);
                } else {
                    ans = Math.min(ans, dfs(houses, cost, m, n, target, cur + 1, i, preGroup + 1, dp) + cost[cur][i]);
                }
            }
        }
        dp[cur][preColor][preGroup] = ans;
        return ans;
    }
}