class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        int m = cost.size();
        vector<int> dp(target + 1, -1);
        dp[0] = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = cost[i]; j <= target; ++j) {
                if (dp[j - cost[i]] >= 0) {
                    dp[j] = max(dp[j], dp[j - cost[i]] + 1);
                }
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        string ans;
        for (int i = m - 1, j = target; i >= 0; --i) {
            int k = cost[i];
            while (j >= k && dp[j] == dp[j - k] + 1) {
                ans += '1' + i;
                j -= k;
            }
        }
        return ans;
    }
};