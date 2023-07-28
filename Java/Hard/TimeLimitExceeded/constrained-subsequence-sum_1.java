class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            int j = i - 1;
            while (j >= 0 && i - j <= k) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                j--;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}