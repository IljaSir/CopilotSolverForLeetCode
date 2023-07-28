class Solution {
    public int getMaxLen(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][2];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = dp[i];
            if (nums[i] > 0) {
                cur[0] = i > 0 ? dp[i - 1][0] + 1 : 1;
                cur[1] = i > 0 && dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
            } else if (nums[i] < 0) {
                cur[0] = i > 0 && dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
                cur[1] = i > 0 ? dp[i - 1][0] + 1 : 1;
            }
            res = Math.max(res, cur[0]);
        }
        return res;
    }
}