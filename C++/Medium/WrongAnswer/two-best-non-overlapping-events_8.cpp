class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        int n = events.size();
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        vector<int> dp(n + 1, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int end = events[i][1];
            int val = events[i][2];
            dp[i + 1] = max(dp[i], dp[i + 1]);
            int j = upper_bound(events.begin(), events.end(), vector<int>{end, 0, 0}, [](const vector<int>& a, const vector<int>& b) {
                return a[0] < b[0];
            }) - events.begin();
            dp[j] = max(dp[j], dp[i + 1] + val);
            ans = max(ans, dp[j]);
        }
        return ans;
    }
};