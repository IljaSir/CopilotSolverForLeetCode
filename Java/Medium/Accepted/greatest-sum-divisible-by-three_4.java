class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int[] dp = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int[] temp = dp.clone();
            for (int j = 0; j < 3; j++) {
                dp[(temp[j] + nums[i]) % 3] = Math.max(dp[(temp[j] + nums[i]) % 3], temp[j] + nums[i]);
            }
        }
        return dp[0];
    }
}