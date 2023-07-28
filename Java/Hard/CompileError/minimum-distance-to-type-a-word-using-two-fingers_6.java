class Solution {
    public int minimumDistance(String word) {
        
        int[][][] dp = new int[27][27][word.length()];
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return dfs(word, 0, 26, 26, dp);
    }
}