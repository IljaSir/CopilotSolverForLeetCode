class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int len = nums.length;
        int[][] dp = new int[len][5001];
        int res = 2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = 2500 + nums[j] - nums[i];
                dp[j][diff] = dp[i][diff] + 1;
                res = Math.max(res, dp[j][diff] + 1);
            }
        }
        return res;
    }
}