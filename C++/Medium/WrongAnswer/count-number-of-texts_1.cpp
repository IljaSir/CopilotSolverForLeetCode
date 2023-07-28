class Solution {
public:
    int countTexts(string pressedKeys) {
        
        int n = pressedKeys.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            if (pressedKeys[i - 1] == pressedKeys[i - 2]) {
                dp[i] = dp[i - 1] * 2 % 1000000007;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
};