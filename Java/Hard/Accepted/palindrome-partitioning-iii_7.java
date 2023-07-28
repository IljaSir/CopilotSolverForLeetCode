class Solution {
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                int j = i + l - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : dp[i + 1][j - 1] + 1;
            }
        }
        int[][] f = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            f[i][0] = dp[0][i];
        }
        for (int j = 1; j < k; j++) {
            for (int i = 0; i < n; i++) {
                for (int i0 = 0; i0 < i; i0++) {
                    f[i][j] = Math.min(f[i][j], f[i0][j - 1] + dp[i0 + 1][i]);
                }
            }
        }
        return f[n - 1][k - 1];
    }
}