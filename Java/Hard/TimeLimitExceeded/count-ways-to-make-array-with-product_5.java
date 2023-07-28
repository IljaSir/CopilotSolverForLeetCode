class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            ans[i] = helper(queries[i][0], queries[i][1]);
        }
        return ans;
    }
    public int helper(int n, int k){
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(i==1){
                    dp[i][j] = 1;
                }else{
                    for(int l=1; l<=j/l; l++){
                        if(j%l==0){
                            dp[i][j] = (dp[i][j]+dp[i-1][l])%mod;
                            if(j/l!=l){
                                dp[i][j] = (dp[i][j]+dp[i-1][j/l])%mod;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][k];
    }
}