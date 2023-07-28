class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i] + 500;
                dp[j][diff] = Math.max(dp[j][diff], dp[i][diff] + 1);
                ans = Math.max(ans, dp[j][diff]);
            }
        }
        return ans + 1;
    }
}