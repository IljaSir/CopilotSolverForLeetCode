class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int mod = 1e9+;
        int dp[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0
        for(int i=0; i<n; i++) {
            if(binary[i] == '0') {
                dp[i+1][0] = dp[i][0] * 2 % mod;
                dp[i+1][1] = dp[i][1] * 2 % mod;
            } else {
                dp[i+1][0] = dp[i][0] * 2 % mod + 1;
                dp[i+1][1] = dp[i][1] * 2 % mod + dp[i][0] + 1;
            }
        }
        return (dp[n][1] + 1) % mod;
7;
    }
};