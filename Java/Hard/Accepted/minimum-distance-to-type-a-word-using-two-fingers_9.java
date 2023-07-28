class Solution {
    public int minimumDistance(String word) {
        
        int[][][] dp = new int[word.length() + 1][27][27];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        return helper(word, 0, 26, 26, dp);
    }
    private int helper(String word, int index, int last1, int last2, int[][][] dp) {
        if (index == word.length()) {
            return 0;
        }
        if (dp[index][last1][last2] != Integer.MAX_VALUE) {
            return dp[index][last1][last2];
        }
        int c = (int) word.charAt(index) - 'A';
        int cost1 = helper(word, index + 1, c, last2, dp) + dist(c, last1);
        int cost2 = helper(word, index + 1, last1, c, dp) + dist(c, last2);
        return dp[index][last1][last2] = Math.min(cost1, cost2);
    }
    private int dist(int c1, int c2) {
        if (c1 == 26) {
            return 0;
        }
        if (c2 == 26) {
            return 0;
        }
        int dx = Math.abs(c1 / 6 - c2 / 6);
        int dy = Math.abs(c1 % 6 - c2 % 6);
        return dx + dy;
    }
}