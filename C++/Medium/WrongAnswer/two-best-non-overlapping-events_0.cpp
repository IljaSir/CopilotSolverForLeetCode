class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        int n = events.size();
        sort(events.begin(), events.end());
        vector<int> dp(n, 0);
        dp[0] = events[0][2];
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (events[m][1] < events[i][0]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp[i] = max(dp[i - 1], events[i][2] + (l > 0 ? dp[l - 1] : 0));
        }
        return dp[n - 1];
    }
};