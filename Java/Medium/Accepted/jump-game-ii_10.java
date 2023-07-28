class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) {
                return -1;
            }
            for (int j = max + 1; j <= Math.min(n - 1, i + nums[i]); j++) {
                dp[j] = dp[i] + 1;
            }
            max = Math.max(max, i + nums[i]);
        }
        return dp[n - 1];
    }
}