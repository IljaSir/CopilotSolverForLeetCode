class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        vector<string> dp(target + 1, "0");
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (i >= cost[j] && dp[i - cost[j]] != "0") {
                    dp[i] = max(dp[i], to_string(j + 1) + dp[i - cost[j]]);
                }
            }
        }
        return dp[target];
    }
};