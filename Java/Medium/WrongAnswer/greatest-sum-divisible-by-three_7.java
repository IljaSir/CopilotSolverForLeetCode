class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int dp[] = new int[3];
        for (int n : nums) {
            int dp2[] = new int[3];
            for (int i = 0; i < 3; i++) {
                dp2[(n + dp[i]) % 3] = Math.max(dp2[(n + dp[i]) % 3], n + dp[i]);
            }
            dp = dp2;
        }
        return dp[0];
    }
}