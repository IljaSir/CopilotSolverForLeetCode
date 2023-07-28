class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int mod = (int)1e9 + 7;
        long[] dp = new long[maxValue+1];
        for(int i=1; i<=maxValue; i++){
            dp[i] = 1;
        }
        for(int i=2; i<=n; i++){
            long[] newDp = new long[maxValue+1];
            for(int j=1; j<=maxValue; j++){
                newDp[j] = (newDp[j-1] + dp[j]) % mod;
            }
            dp = newDp;
        }
        long res = 0;
        for(int i=1; i<=maxValue; i++){
            res = (res + dp[i]) % mod;
        }
        return (int)res;
    }
}