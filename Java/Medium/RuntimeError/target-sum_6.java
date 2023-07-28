class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = w; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[w];
    }
}