class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] - nums[i] == nums[k] - nums[j]) {
                        dp[j][k] = Math.max(dp[j][k], dp[i][j] + 1);
                        ans = Math.max(ans, dp[j][k]);
                    }
                }
            }
        }
        return ans;
    }
}