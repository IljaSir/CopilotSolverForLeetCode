class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        vector<int> dp(target + 1, -1);
        dp[0] = 0;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (i >= cost[j] && dp[i - cost[j]] >= 0) {
                    dp[i] = max(dp[i], dp[i - cost[j]] + 1);
                }
            }
        }
        if (dp.back() < 0) {
            return "0";
        }
        string ans;
        for (int i = 8, j = target; i >= 0; --i) {
            while (j >= cost[i] && dp[j] == dp[j - cost[i]] + 1) {
                ans += '1' + i;
                j -= cost[i];
            }
        }
        return ans;
    }
};