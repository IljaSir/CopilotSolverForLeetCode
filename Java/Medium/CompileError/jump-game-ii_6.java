class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j
        }
        return dp[n - 1];
    }
}