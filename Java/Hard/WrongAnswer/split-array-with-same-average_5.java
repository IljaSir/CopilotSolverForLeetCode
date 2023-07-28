class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        boolean[][][] dp = new boolean[n][n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0][nums[i]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 1; k <= sum; k++) {
                    if (k >= nums[i] && dp[i - 1][j - 1][k - nums[i]]) {
                        dp[i][j][k] = true;
                    } else if (dp[i - 1][j][k]) {
                        dp[i][j][k] = true;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0 && dp[n - 1][i][sum * i / n]) {
                return true;
            }
        }
        return false;
    }
}