class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.length();
        long long dp[n+1];
        dp[0] = 0;
        dp[1] = (binary[0] == '1') ? 1 : 0;
        int prev = (binary[0] == '0') ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            if(binary[i-1] == '0') {
                dp[i] = dp[i-1];
                prev = i;
            } else {
                dp[i] = (dp[i-1] + dp[prev]) % 1000000007;
            }
        }
        return (dp[n] + 1) % 1000000007;
    }
};