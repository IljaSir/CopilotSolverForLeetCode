class Solution {
    public int tallestBillboard(int[] rods) {
        
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[][] dp = new int[rods.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(rods, 0, 0, 0, dp);
    }
    
    public int dfs(int[] rods, int index, int sum1, int sum2, int[][] dp) {
        if (index == rods.length) {
            if (sum1 == sum2) {
                return sum1;
            }
            return 0;
        }
        if (dp[index][sum1] != -1) {
            return dp[index][sum1];
        }
        int result = 0;
        if (sum1 >= sum2) {
            result = Math.max(result, dfs(rods, index + 1, sum1, sum2 + rods[index], dp));
            result = Math.max(result, dfs(rods, index + 1, sum1 + rods[index], sum2, dp));
            result = Math.max(result, dfs(rods, index + 1, sum1, sum2, dp));
        } else {
            result = Math.max(result, dfs(rods, index + 1, sum1, sum2 + rods[index], dp));
            result = Math.max(result, dfs(rods, index + 1, sum1, sum2, dp));
        }
        dp[index][sum1] = result;
        return result;
    }
}