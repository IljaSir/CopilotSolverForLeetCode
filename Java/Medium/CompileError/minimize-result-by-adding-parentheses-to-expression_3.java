class Solution {
    public String minimizeResult(String expression) {
        
        String[] nums = expression.split("\\+");
        int n = nums.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = num[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                for (int k = j; k < j + i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]);
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] * dp[k + 1][j + i]);
                }
            }
        }
        int[][] min = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            min[i][i] = num[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                for (int k = j; k < j + i; k++) {
                    if (dp[j][k] + dp[k + 1][j + i] == dp[j][j + i]) {
                        min[j][j + i] = Math.min(min[j][j + i], min[j][k] + min[k + 1][j + i]);
                    }
                    if (dp[j][k] * dp[k + 1][j + i] == dp[j][j + i]) {
                        min[j][j +
    }
}