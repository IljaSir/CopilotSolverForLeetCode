class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> dp(n);
        dp[n-1] = stoneValue[n-1];
        for (int i = n - 2; i >= 0; --i) {
            dp[i] = stoneValue[i];
            for (int j = i + 1; j < n && j <= i + 3; ++j) {
                dp[i] = max(dp[i], dp[j] - dp[i]);
            }
        }
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
};