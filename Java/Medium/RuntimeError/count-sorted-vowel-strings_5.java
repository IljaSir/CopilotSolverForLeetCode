class Solution {
    public int countVowelStrings(int n) {
        
        int[][] dp = new int[n+1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][4];
    }
}