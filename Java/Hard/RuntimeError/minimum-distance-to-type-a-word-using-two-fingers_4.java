class Solution {
    public int minimumDistance(String word) {
        
        int n = word.length();
        int[][][] dp = new int[n][26][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return minimumDistance(word, 0, -1, -1, dp);
    }

    private int minimumDistance(String word, int i, int f1, int f2, int[][][] dp) {
        if (i == word.length()) {
            return 0;
        }
        if (dp[i][f1 + 1][f2 + 1] != Integer.MAX_VALUE) {
            return dp[i][f1 + 1][f2 + 1];
        }
        int c = word.charAt(i) - 'A';
        int d1 = f1 == -1 ? 0 : dist(c, f1);
        int d2 = f2 == -1 ? 0 : dist(c, f2);
        int res = Math.min(minimumDistance(word, i + 1, c, f2, dp) + d1,
                minimumDistance(word, i + 1, f1, c, dp) + d2);
        dp[i][f1 + 1][f2 + 1] = res;
        return res;
    }

    private int dist(int c1, int c2) {
        int r1 = c1 / 6, c11 = c1 % 6;
        int r2 = c2 / 6, c22 = c2 % 6;
        return Math.abs(r1 - r2) + Math.abs(c11 - c22);
    }
}