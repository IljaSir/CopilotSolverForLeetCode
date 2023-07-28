class Solution {
    public int minimumDifference(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[i]) {
                min = Math.min(min, sum - 2 * i);
            }
        }
        return min;
    }
}