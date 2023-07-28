class Solution {
    public int twoEggDrop(int n) {
        
        int dp[][] = new int[n+1][3];
        for(int i=0;i<=n;i++){
            dp[i][1] = i;
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=2;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<=i;x++){
                    int temp = 1 + Math.max(dp[x-1][j-1],dp[i-x][j]);
                    dp[i][j] = Math.min(dp[i][j],temp);
                }
            }
        }
        return dp[n][2];
    }
}