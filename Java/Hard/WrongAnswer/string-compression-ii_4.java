class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int len = 0, cnt = 0;
                for (int p = i; p > 0; p--) {
                    if (s.charAt(p - 1) == s.charAt(i - 1)) {
                        cnt++;
                    } else {
                        len++;
                    }
                    if (cnt > 1) {
                        len++;
                    }
                    if (cnt > 9) {
                        len++;
                    }
                    if (cnt > 99) {
                        len++;
                    }
                    if (j >= i - p) {
                        if (dp[p - 1][j - (i - p)] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - (i - p)] + len);
                        }
                    }
                }
            }
        }
        return dp[n][k];
    }
}