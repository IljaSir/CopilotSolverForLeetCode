class Solution {
    public int minimumDistance(String word) {
        
        int[][][] dp = new int[27][27][word.length()];
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(dp, word, 0, 0, 0);
    }
    
    private int dfs(int[][][] dp, String word, int i, int l, int r) {
        if (i == word.length()) {
            return 0;
        }
        if (dp[l][r][i] != -1) {
            return dp[l][r][i];
        }
        int p = word.charAt(i) - 'A';
        int cost = Math.abs(p / 6 - l / 6) + Math.abs(p % 6 - l % 6);
        int cost1 = dfs(dp, word, i + 1, p, r) + cost;
        cost = Math.abs(p / 6 - r / 6) + Math.abs(p % 6 - r % 6);
        int cost2 = dfs(dp, word, i + 1, l, p) + cost;
        dp[l][r][i] = Math.min(cost1, cost2);
        return dp[l][r][i];
    }
}