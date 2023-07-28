class Solution {
    public String minimizeResult(String expression) {
        
        String[] nums = expression.split("\\+");
        int[] numsInt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInt[i] = Integer.parseInt(nums[i]);
        }
        int[][] dp = new int[numsInt.length][numsInt.length];
        for (int i = 0; i < numsInt.length; i++) {
            dp[i][i] = numsInt[i];
        }
        for (int i = 1; i < numsInt.length; i++) {
            for (int j = 0; j < numsInt.length - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]);
                }
            }
        }
        return dfs(numsInt, dp, 0, numsInt.length - 1);
    }

    private String dfs(int[] nums, int[][] dp, int i, int j) {
        if (i == j) {
            return String.valueOf(nums[i]);
        }
        if (dp[i][j] == dp[i][j - 1] + nums[j]) {
            return dfs(nums, dp, i, j - 1) + "+" + nums[j];
        }
        for (int k = i; k < j; k++) {
            if (dp[i][j] == dp[i][k] + dp[k + 1][j]) {
                return "(" + dfs(nums, dp, i, k) + ")" + "+" + dfs(nums, dp, k + 1, j);
            }
        }
        return "";
    }
}