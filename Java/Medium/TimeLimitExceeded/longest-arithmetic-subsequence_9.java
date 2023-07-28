class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                dp[i][j] = 2;
                for(int k = i - 1; k >= 0; k--) {
                    if(nums[i] - nums[k] == nums[j] - nums[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}