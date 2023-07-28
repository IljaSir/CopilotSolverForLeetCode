class Solution {
public:
    int countTexts(string pressedKeys) {
        
        int n = pressedKeys.size();
        vector<int> dp(n+1);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1];
            if (i >= 2 && pressedKeys[i-2] == pressedKeys[i-1]) {
                dp[i] = (dp[i] + dp[i-2]) % (int)(1e9+7);
            }
        }
        return dp[n];
    }
};