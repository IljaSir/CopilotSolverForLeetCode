class Solution {
public:
    int countTexts(string pressedKeys) {
        
        int n = pressedKeys.size();
        int MOD = 1e9 + 7;
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            if (i > 1 && pressedKeys[i - 1] == pressedKeys[i - 2]) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }
        return dp[n];
    }
};