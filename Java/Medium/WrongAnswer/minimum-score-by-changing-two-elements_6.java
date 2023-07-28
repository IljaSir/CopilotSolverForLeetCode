class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = nums[i] - nums[i - 1];
        }
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum += dp[i];
        }
        int min = sum;
        for (int i = 2; i < n; i++) {
            int a = nums[i - 1] - nums[i - 2];
            int b = nums[i] - nums[i - 1];
            int c = nums[i] - nums[i - 2];
            sum = sum - dp[i] - dp[i - 1];
            sum = sum + a + b + c;
            min = Math.min(min, sum);
        }
        return min;
    }
}