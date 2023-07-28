class Solution {
public:
    int countTexts(string pressedKeys) {
        
        int MOD = 1e9 + 7;
        int n = pressedKeys.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            int c = pressedKeys[i] - '0';
            if (c == 1) {
                dp[i + 1] = 0;
            } else if (c == 7 || c == 9) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
            dp[i + 1] %= MOD;
        }
        return dp[n];
    }
};