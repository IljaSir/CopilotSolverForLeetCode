class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int c : count) {
            if (c % 2 == 1) {
                odd++;
            }
        }
        if (odd > k) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                } else {
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j][i - 1] >= k) {
                    f[i] = (f[i] + f[j]) % 1000000007;
                }
            }
        }
        return f[n];
    }
}