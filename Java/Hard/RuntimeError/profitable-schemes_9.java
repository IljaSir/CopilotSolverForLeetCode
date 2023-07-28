class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int[][][] dp = new int[group.length][n+1][minProfit+1];
        int mod = 1000000007;
        for(int i=0; i<group.length; i++) {
            for(int j=0; j<=n; j++) {
                for(int k=0; k<=minProfit; k++) {
                    int without = i > 0 ? dp[i-1][j][k] : 0;
                    int with = 0;
                    if(j >= group[i]) {
                        with = (k - profit[i] >= 0 ? dp[i][j-group[i]][k-profit[i]] : dp[i][j-group[i]][0]) + (i > 0 ? dp[i-1][j-group[i]][k-profit[i]] : 1);
                    }
                    dp[i][j][k] = (without + with) % mod;
                }
            }
        }
        return dp[group.length-1][n][minProfit];
    }
}