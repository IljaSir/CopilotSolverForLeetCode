class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        sort(events.begin(), events.end());
        int n = events.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0], end = events[i - 1][1], value = events[i - 1][2];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                auto it = upper_bound(events.begin(), events.begin() + i - 1, vector<int>{end, 0, 0});
                if (it != events.begin()) {
                    dp[i][j] = max(dp[i][j], dp[it - events.begin()][j - 1] + value);
                }
            }
        }
        return dp[n][k];
    }
};