class Solution {
    public int minimumDistance(String word) {
        
        int n = word.length();
        int[][][] dp = new int[n][27][27];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return dfs(word, 0, 26, 26, dp);
    }
    private int dfs(String word, int i, int f1, int f2, int[][][] dp) {
        if (i == word.length()) {
            return 0;
        }
        if (dp[i][f1][f2] != Integer.MAX_VALUE) {
            return dp[i][f1][f2];
        }
        int c = word.charAt(i) - 'A';
        int res = dfs(word, i + 1, c, f2, dp) + dist(f1, c);
        res = Math.min(res, dfs(word, i + 1, f1, c, dp) + dist(f2, c));
        return dp[i][f1][f2] = res;
    }
    private int dist(int i, int j) {
        if (i == 26) {
            return 0;
        }
        return Math.abs(i / 6 - j / 6) + Math.abs(i % 6 - j % 6);
    }
}