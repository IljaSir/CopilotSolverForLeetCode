class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                    int[] count = new int[26];
                    for (int k = i + 1; k < j; k++) {
                        count[s.charAt(k) - 'a']++;
                    }
                    for (int k = 0; k < 26; k++) {
                        if (count[k] > 0) {
                            dp[i][j]++;
                        }
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}