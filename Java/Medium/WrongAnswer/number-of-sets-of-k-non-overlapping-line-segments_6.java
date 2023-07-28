class Solution {
    public int numberOfSets(int n, int k) {
        
        int mod = 1000000007;
        long[][] dp = new long[k+1][n+1];
        for(int i=1;i<=k;i++){
            for(int j=i*2;j<=n;j++){
                if(i==1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-1])%mod;
                }
            }
        }
        long ans = 0;
        for(int i=1;i<=n;i++){
            ans = (ans + dp[k][i])%mod;
        }
        return (int)ans;
    }
}