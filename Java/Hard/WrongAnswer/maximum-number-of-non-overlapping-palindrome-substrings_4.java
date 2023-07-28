class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 0;
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j][i - 1] == 1) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n];
    }
}