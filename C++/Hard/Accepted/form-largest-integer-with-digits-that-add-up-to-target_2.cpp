class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        vector<int> dp(target + 1, -1);
        dp[0] = 0;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (i >= cost[j] && dp[i - cost[j]] != -1) {
                    dp[i] = max(dp[i], dp[i - cost[j]] + 1);
                }
            }
        }
        if (dp[target] == -1) return "0";
        string ans;
        for (int i = 8; i >= 0; --i) {
            while (target >= cost[i] && dp[target] == dp[target - cost[i]] + 1) {
                ans += (char)('1' + i);
                target -= cost[i];
            }
        }
        return ans;
    }
};