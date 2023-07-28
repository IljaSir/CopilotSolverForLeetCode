class Solution {
public:
    int countTexts(string pressedKeys) {
        
        const int MOD = 1e9 + 7;
        int n = pressedKeys.size();
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            if (pressedKeys[i] == pressedKeys[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = (dp[i - 1] * 2) % MOD;
            }
        }
        return dp[n - 1];
    }
};