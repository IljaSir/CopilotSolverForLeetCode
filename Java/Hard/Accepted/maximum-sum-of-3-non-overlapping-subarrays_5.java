class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[][] dp = new int[4][nums.length + 1];
        int[][] pos = new int[4][nums.length + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= nums.length; j++) {
                int s = sum[j] - sum[j - k] + dp[i - 1][j - k];
                if (s > dp[i][j - 1]) {
                    dp[i][j] = s;
                    pos[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];
                }
            }
        }
        int[] ans = new int[3];
        ans[2] = pos[3][nums.length];
        ans[1] = pos[2][ans[2]];
        ans[0] = pos[1][ans[1]];
        return ans;
    }
}