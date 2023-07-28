class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](auto& a, auto& b) {
            return a[1] < b[1];
        });
        int n = events.size();
        vector<int> dp(n, 0);
        dp[0] = events[0][2];
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (events[m][1] < events[i][0]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            dp[i] = max(dp[i - 1], events[i][2] + (l < 0 ? 0 : dp[l]));
        }
        return dp[n - 1];
    }
};