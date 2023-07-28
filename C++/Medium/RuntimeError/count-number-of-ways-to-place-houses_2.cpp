class Solution {
public:
    int countHousePlacements(int n) {
        
        int mod = 1e9 + 7;
        vector<int> dp(n + 1);
        dp[0] = 1;
        dp[1] = 4;
        dp[2] = 9;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }
        return dp[n];
    }
};