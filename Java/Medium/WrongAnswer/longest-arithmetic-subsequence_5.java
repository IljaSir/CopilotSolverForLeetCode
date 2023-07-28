class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[i] - nums[j];
                for (int k = 0; k < i; k++) {
                    if (nums[i] - nums[k] == diff) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max + 2;
    }
}