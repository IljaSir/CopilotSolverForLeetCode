class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int mid = i; mid < j; mid++) {
                    if (dp[i][mid] != Integer.MAX_VALUE && dp[mid + 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][mid], dp[mid + 1][j]));
                    }
                }
            }
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            f[i] = sum[n] - sum[i] - dp[i][n - 1];
        }
        for (int i = 1; i < k; i++) {
            int[] g = new int[n];
            Arrays.fill(g, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < j; x++) {
                    if (dp[x + 1][j] != Integer.MAX_VALUE) {
                        g[j] = Math.min(g[j], Math.max(f[x], sum[n] - sum[x + 1] - dp[x + 1][j]));
                    }
                }
            }
            f = g;
        }
        return f[n - 1];
    }
}