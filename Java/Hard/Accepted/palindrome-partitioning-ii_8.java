class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (pal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (pal[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}