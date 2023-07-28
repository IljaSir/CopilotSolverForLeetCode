class Solution {
    public int numTilings(int n) {
        
        long[] dp = new long[n+1];
        for(int i=0; i<=n; i++){
            if(i==0){
                dp[i] = 1;
            }else if(i==1){
                dp[i] = 1;
            }else if(i==2){
                dp[i] = 2;
            }else{
                dp[i] = (2*dp[i-1] + dp[i-3])%1000000007;
            }
        }
        return (int)dp[n];
    }
}