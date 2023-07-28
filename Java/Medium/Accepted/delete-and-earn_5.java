class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] arr = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }
        int[] dp = new int[10001];
        dp[1] = arr[1];
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[10000];
    }
}