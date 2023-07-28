class Solution {
    public int longestSubarray(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                max = dp[i];
            } else {
                dp[i] = (dp[i - 1] & nums[i]);
                max = Math.max(max, dp[i]);
            }
        }
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == max) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}