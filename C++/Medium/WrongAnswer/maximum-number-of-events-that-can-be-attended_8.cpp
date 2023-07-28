class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        int n = events.size();
        vector<int> dp(n + 1, 0);
        sort(events.begin(), events.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] < b[0];
        });
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (events[j][1] < events[i - 1][0]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = max(dp[i], dp[j]);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};