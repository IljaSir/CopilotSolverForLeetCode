class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 10000);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                int count = 1;
                int del = 0;
                for (int p = i - 1; p >= 0; p--) {
                    if (s.charAt(p) == s.charAt(i - 1)) {
                        count++;
                    } else {
                        del++;
                    }
                    if (del > j) {
                        break;
                    }
                    int len = 0;
                    if (count >= 100) {
                        len = 3;
                    } else if (count >= 10) {
                        len = 2;
                    } else {
                        len = 1;
                    }
                    if (count == 1) {
                        len = 0;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[p][j - del] + len + 1);
                }
            }
        }
        return dp[n][k];
    }
}