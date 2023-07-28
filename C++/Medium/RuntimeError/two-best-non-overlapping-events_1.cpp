class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end());
        int n = events.size();
        vector<int> dp(n);
        dp[0] = events[0][2];
        for (int i = 1; i < n; ++i) {
            dp[i] = max(dp[i - 1], events[i][2]);
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r) / 2;
                if (events[mid][1] < events[i][0]) l = mid + 1;
                else r = mid;
            }
            dp[i] = max(dp[i], dp[l - 1] + events[i][2]);
        }
        return dp[n - 1];
    }
};