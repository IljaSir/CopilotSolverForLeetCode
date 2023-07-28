class Solution {
public:
    int minSpaceWastedKResizing(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(k + 1, INT_MAX));
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; ++i)
            prefix[i + 1] = prefix[i] + nums[i];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 0;
            for (int j = 0; j < i; ++j) {
                int cur = max(prefix[i + 1] - prefix[j], nums[j]);
                for (int t = 1; t <= k; ++t) {
                    if (dp[j][t - 1] != INT_MAX)
                        dp[i][t] = min(dp[i][t], dp[j][t - 1] + cur - nums[i]);
                }
            }
        }
        return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};