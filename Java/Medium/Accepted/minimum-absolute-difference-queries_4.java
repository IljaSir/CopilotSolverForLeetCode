class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int[] res = new int[queries.length];
        int[][] dp = new int[n + 1][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][nums[i - 1]]++;
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int prev = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (dp[r + 1][j] - dp[l][j] > 0) {
                    if (prev != -1) {
                        min = Math.min(min, j - prev);
                    }
                    prev = j;
                }
            }
            res[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return res;
    }
}