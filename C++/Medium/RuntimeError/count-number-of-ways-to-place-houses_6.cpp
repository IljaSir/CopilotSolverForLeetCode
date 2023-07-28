class Solution {
public:
    int countHousePlacements(int n) {
        
        // write your code here
        int mod = 1e9 + 7;
        vector<long long> dp(n + 1, 0);
        dp[1] = 4;
        dp[2] = 9;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            dp[i] = (dp[i] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
};