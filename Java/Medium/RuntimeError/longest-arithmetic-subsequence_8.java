class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][501];
        int res = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i] + 250;
                dp[j][diff] = Math.max(dp[j][diff], dp[i][diff] + 1);
                res = Math.max(res, dp[j][diff] + 1);
            }
        }
        return res;
    }
}