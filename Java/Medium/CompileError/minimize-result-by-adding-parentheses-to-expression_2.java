class Solution {
    public String minimizeResult(String expression) {
        
        String[] nums = expression.split("\\+");
        int n = nums.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = num[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    int left = dp[i][k];
                    int right = dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], left + right);
                    dp[i][j] = Math.min(dp[i][j], left * right);
                }
            }
        }
        int[][] par = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                par[i][j] = -1;
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    int left = dp[i][k];
                    int right = dp[k + 1][j];
                    if (left + right == dp[i][j]) {
                        par[i][j] = k;
                    } else if (left * right == dp[i][j]) {
                        par[i][j] = k;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, n - 1, par, num);
        return sb.toString();
    }
}