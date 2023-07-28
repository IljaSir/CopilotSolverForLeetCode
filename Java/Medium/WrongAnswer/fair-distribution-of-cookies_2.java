class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
        Arrays.sort(cookies);
        int n = cookies.length;
        int[][] dp = new int[n][k];
        dp[0][0] = cookies[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + cookies[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                if (j > i) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int m = j - 1; m < i; m++) {
                        min = Math.min(min, dp[m][j - 1] + cookies[i] * (i - m));
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[n - 1][k - 1];
    }
}