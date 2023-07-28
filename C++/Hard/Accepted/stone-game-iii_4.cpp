class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> dp(n + 1);
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = INT_MIN;
            for (int x = 0, k = 1; k <= 3 && i + k <= n; ++k) {
                x += stoneValue[i + k - 1];
                dp[i] = max(dp[i], x - dp[i + k]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
};