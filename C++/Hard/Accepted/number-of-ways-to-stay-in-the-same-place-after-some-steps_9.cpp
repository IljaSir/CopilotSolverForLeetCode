class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        int mod = 1e9 + 7;
        int size = min(steps + 1, arrLen);
        vector<long long> dp(size, 0);
        dp[0] = 1;
        for(int i = 0; i < steps; ++i) {
            vector<long long> temp(size, 0);
            for(int j = 0; j < size; ++j) {
                temp[j] = dp[j];
                if(j > 0) {
                    temp[j] = (temp[j] + dp[j - 1]) % mod;
                }
                if(j < size - 1) {
                    temp[j] = (temp[j] + dp[j + 1]) % mod;
                }
            }
            dp = temp;
        }
        return dp[0];
    }
};