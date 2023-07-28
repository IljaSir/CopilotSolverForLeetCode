class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = count[1];
        for(int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i] * i);
        }
        return dp[max];
    }
}