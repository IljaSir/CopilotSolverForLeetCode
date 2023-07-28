class Solution {
    public int twoEggDrop(int n) {
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[][] dp = new int[n + 1][3];
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= 2; i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= 2; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 1; k <= i; k++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
            }
        }
        return dp[n][2];
    }
}