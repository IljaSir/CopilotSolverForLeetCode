class Solution {
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            f[i][1] = dp[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    f[i][j] = Math.min(f[i][j], f[l][j - 1] + dp[l + 1][i]);
                }
            }
        }
        return f[n - 1][k];
    }
}