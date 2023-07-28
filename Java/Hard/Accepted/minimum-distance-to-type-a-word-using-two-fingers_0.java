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
    
    int dfs(String word, int i, int l1, int l2, int[][][] dp) {
        if (i == word.length()) {
            return 0;
        }
        if (dp[i][l1][l2] != Integer.MAX_VALUE) {
            return dp[i][l1][l2];
        }
        int c1 = word.charAt(i) - 'A';
        int cost = dfs(word, i + 1, c1, l2, dp) + dist(l1, c1);
        cost = Math.min(cost, dfs(word, i + 1, l1, c1, dp) + dist(l2, c1));
        return dp[i][l1][l2] = cost;
    }
    
    int dist(int l1, int l2) {
        if (l1 == 26) {
            return 0;
        }
        int x1 = l1 / 6, y1 = l1 % 6;
        int x2 = l2 / 6, y2 = l2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}