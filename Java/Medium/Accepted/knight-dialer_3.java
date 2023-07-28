class Solution {
    public int knightDialer(int n) {
        
        int[][] moves = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[1], 1);
        int mod = 1000000007;
        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<moves[j].length; k++) {
                    dp[i][j] += dp[i-1][moves[j][k]];
                    dp[i][j] %= mod;
                }
            }
        }
        int res = 0;
        for(int i=0; i<10; i++) {
            res += dp[n][i];
            res %= mod;
        }
        return res;
    }
}