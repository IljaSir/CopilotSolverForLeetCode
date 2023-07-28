class Solution {
    public int minimumDistance(String word) {
        
        int n = word.length();
        int[][][] dp = new int[n][27][27];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n - 1; i++) {
            int c1 = word.charAt(i) - 'A' + 1;
            int c2 = word.charAt(i + 1) - 'A' + 1;
            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {
                    if (dp[i][f1][f2] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i + 1][f1][c2] = Math.min(dp[i + 1][f1][c2], dp[i][f1][f2] + dist(f2, c2));
                    dp[i + 1][c1][f2] = Math.min(dp[i + 1][c1][f2], dp[i][f1][f2] + dist(f1, c1));
                    dp[i + 1][c1][c2] = Math.min(dp[i + 1][c1][c2], dp[i][f1][f2] + dist(f1, c1) + dist(f2, c2));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int f1 = 0; f1 < 27; f1++) {
            for (int f2 = 0; f2 < 27; f2++) {
                res = Math.min(res, dp[n - 1][f1][f2]);
            }
        }
        return res;
    }
    
    int dist(int c1, int c2) {
        if (c1 == 0 || c2 == 0) {
            return 0;
        }
        return Math.abs((c1 - 1) / 6 - (c2 - 1) / 6) + Math.abs((c1 - 1
    }
}