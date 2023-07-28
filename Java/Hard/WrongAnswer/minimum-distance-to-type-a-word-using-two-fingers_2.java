class Solution {
    public int minimumDistance(String word) {
        
        int n = word.length();
        int[][][] dp = new int[n][27][27];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n - 1; i++) {
            int c1 = word.charAt(i) - 'A';
            int c2 = word.charAt(i + 1) - 'A';
            for (int j = 0; j < 27; j++) {
                for (int k = 0; k < 27; k++) {
                    dp[i + 1][j][c2] = Math.min(dp[i + 1][j][c2], dp[i][j][k] + dist(k, c2));
                    dp[i + 1][c1][k] = Math.min(dp[i + 1][c1][k], dp[i][j][k] + dist(j, c1));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ans = Math.min(ans, dp[n - 1][i][j]);
            }
        }
        return ans;
    }

    private int dist(int c1, int c2) {
        if (c1 == 26 || c2 == 26) {
            return 0;
        }
        return Math.abs(c1 / 6 - c2 / 6) + Math.abs(c1 % 6 - c2 % 6);
    }
}