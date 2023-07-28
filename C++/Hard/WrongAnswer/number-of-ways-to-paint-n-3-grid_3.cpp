class Solution {
public:
    int numOfWays(int n) {
        
        vector<long> dp(3, 6);
        for (int i = 1; i < n; ++i) {
            vector<long> ndp(3);
            ndp[0] = dp[0] * 2 + dp[1] * 2;
            ndp[1] = dp[0] * 2 + dp[2] * 2;
            ndp[2] = dp[1] * 2 + dp[2] * 2;
            for (int j = 0; j < 3; ++j) {
                ndp[j] %= 1000000007;
            }
            dp = ndp;
        }
        return (dp[0] + dp[1] + dp[2]) % 1000000007;
    }
};