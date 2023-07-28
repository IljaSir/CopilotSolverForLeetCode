class Solution {
public:
    int idealArrays(int n, int maxValue) {
        
        int mod = 1e9 + 7;
        vector<int> dp(maxValue + 1, 0);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            vector<int> dp2(maxValue + 1, 0);
            for (int j = 1; j <= maxValue; j++) {
                for (int k = 1; k * j <= maxValue; k++) {
                    dp2[k * j] = (dp2[k * j] + dp[j]) % mod;
                }
            }
            dp = move(dp2);
        }
        int res = 0;
        for (int i = 1; i <= maxValue; i++) {
            res = (res + dp[i]) % mod;
        }
        return res;
    }
};