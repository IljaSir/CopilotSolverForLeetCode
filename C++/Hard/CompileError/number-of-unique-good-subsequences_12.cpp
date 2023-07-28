class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int mod = 1e9 + 7;
        int dp[n+1][2];
        memset(dp, 0, sizeof(dp));
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i <= n; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            if(binary[i-1] == '0'){
                dp[i][0] = (dp[i][0] + dp[i-1][1]) % mod;
            }else{
                dp[i][0] = (dp[i][0] + dp[i-1][0]) % mod;
                dp[i][1] = (dp[i][1] + dp[i-1][1]) % mod;
                dp[i][1] = (dp[i][1] + dp[i-1][0] + 1) % mod;
            }7;
    }
};