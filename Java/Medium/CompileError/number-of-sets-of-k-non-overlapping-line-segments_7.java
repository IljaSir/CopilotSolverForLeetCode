class Solution {
    public int numberOfSets(int n, int k) {
        
        long[][][] dp = new long[n][k+1][2];
        int mod = 1000000007;
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return (int) solve(0,0,k,dp,mod);
    }
    public long solve(int i,int j,int k,long[][][] dp,int mod){
        if(j==k){
            return 1;
        }
        if(i>=dp.length){
            return 0;
        }
        if(dp[i][j][0]!=-1){
            return dp[i][j][0];
        }
        long ans = 0;
        ans = (ans+solve(i+1,j,k,dp,mod))%mod;
        if(i+1<dp.length){
            ans = (ans+solve(i+2,j+1,k,dp,mod))%mod;
        }
        dp[i][j][0] = ans;
        return ans;
    }
}
    }
}