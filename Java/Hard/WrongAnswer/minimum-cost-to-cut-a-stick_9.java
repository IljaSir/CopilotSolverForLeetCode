class Solution {
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        int[] dp = new int[cuts.length + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = cuts[i - 1];
        }
        int[][] memo = new int[cuts.length + 1][cuts.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(dp, 0, cuts.length, memo);
    }
    
    private int dfs(int[] dp, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j];
        if (i + 1 == j) return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
            res = Math.min(res, dfs(dp, i, k, memo) + dfs(dp, k, j, memo) + dp[j] - dp[i]);
        }
        return memo[i][j] = res;
    }
}