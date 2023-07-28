class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
        }
        return sum;
    }
}