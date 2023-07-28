class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.length();
        int mod = 1e9 + 7;
        long long int dp[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i <= n; i++) {
            if(binary[i - 1] == '0') {
                dp[i][0] = dp[i - 1][0] * 2 % mod;
                dp[i][1] = dp[i - 1][1] * 2 % mod;
            } else {
                dp[i][0] = dp[i - 1][0] * 2 % mod + 1;
                dp[i][1] = dp[i - 1][1] * 2 % mod + dp[i - 1][0] + 1;
            }
        }
        return (dp[n][0] + dp[n][1]) % mod;
    }
};