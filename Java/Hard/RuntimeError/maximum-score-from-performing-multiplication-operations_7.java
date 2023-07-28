class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int[] ndp = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                int l = j - 1 >= 0 ? dp[j - 1] : Integer.MIN_VALUE;
                int r = j < i ? dp[j] : Integer.MIN_VALUE;
                ndp[j] = Math.max(l + nums[j] * multipliers[i - 1], r + nums[n + j - i] * multipliers[i - 1]);
            }
            dp = ndp;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}