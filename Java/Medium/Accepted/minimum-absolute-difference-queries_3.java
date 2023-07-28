class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];
        int[][] dp = new int[n][101];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = i > 0 ? dp[i - 1][j] : 0;
            }
            dp[i][nums[i]]++;
        }
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int prev = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (l > 0) {
                    if (dp[r][j] - dp[l - 1][j] > 0) {
                        if (prev != -1) {
                            min = Math.min(min, j - prev);
                        }
                        prev = j;
                    }
                } else {
                    if (dp[r][j] > 0) {
                        if (prev != -1) {
                            min = Math.min(min, j - prev);
                        }
                        prev = j;
                    }
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}