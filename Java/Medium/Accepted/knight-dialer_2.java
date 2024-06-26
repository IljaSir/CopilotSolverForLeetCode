class Solution {
    public int knightDialer(int n) {
        
        int[][] moves = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int[][] dp = new int[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < moves[j].length; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][moves[j][k]]) % 1000000007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % 1000000007;
        }
        return sum;
    }
}