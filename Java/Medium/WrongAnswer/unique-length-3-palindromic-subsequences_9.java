class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        int[][] last = new int[n][26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(last[i], -1);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j]++;
                    if (i + 1 < j) {
                        dp[i][j] -= dp[i + 1][j - 1];
                    }
                }
                for (int k = 0; k < 26; k++) {
                    if (last[i + 1][k] > last[i][k]) {
                        last[i][k] = last[i + 1][k];
                    }
                }
                last[i][s.charAt(i) - 'a'] = j;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (last[0][i] > 0) {
                res += dp[0][last[0][i]];
            }
        }
        return res;
    }
}