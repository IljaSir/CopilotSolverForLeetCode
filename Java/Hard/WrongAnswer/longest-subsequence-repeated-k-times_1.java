class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int n = s.length();
        int[][][] dp = new int[n + 1][n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= k; l++) {
                    if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                        dp[i][j][l] = dp[i - 1][j - 1][l - 1] + 1;
                    } else {
                        dp[i][j][l] = Math.max(dp[i - 1][j][l], dp[i][j - 1][l]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n, j = n, l = k;
        while (i > 0 && j > 0 && l > 0) {
            if (dp[i][j][l] == dp[i - 1][j][l]) {
                i--;
            } else if (dp[i][j][l] == dp[i][j - 1][l]) {
                j--;
            } else {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
                l--;
            }
        }
        return sb.reverse().toString();
    }
}