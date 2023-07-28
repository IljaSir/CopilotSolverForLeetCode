class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end());
        int n = events.size();
        int dp[n];
        dp[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = max(dp[i-1], events[i][2]);
            int l = 0, r = i-1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (events[mid][1] < events[i][0]) l = mid;
                else r = mid-1;
            }
            if (events[l][1] < events[i][0]) dp[i] = max(dp[i], dp[l] + events[i][2]);
        }
        return dp[n-1];
    }
};