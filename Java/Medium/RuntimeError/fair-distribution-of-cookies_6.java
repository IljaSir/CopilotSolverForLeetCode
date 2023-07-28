class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int n = cookies.length;
        int[][] dp = new int[n][k + 1];
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum[i][j] = (i == j ? cookies[i] : sum[i][j - 1] + cookies[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= i; l++) {
                    if (j == 1) {
                        dp[i][j] = Math.min(dp[i][j], sum[l][i]);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + sum[l + 1][i]);
                    }
                }
            }
        }
        return dp[n - 1][k];
    }
}