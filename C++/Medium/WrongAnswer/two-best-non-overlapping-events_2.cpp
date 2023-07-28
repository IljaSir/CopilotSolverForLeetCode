class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](auto& a, auto& b) {
            if (a[1] != b[1]) return a[1] < b[1];
            return a[0] < b[0];
        });
        int n = events.size();
        vector<int> dp(n, 0);
        vector<int> last(n, 0);
        dp[0] = events[0][2];
        last[0] = events[0][1];
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1];
            last[i] = last[i - 1];
            int j = upper_bound(events.begin(), events.begin() + i, vector<int>{last[i - 1] + 1, 0, 0}, [](auto& a, auto& b) {
                return a[0] < b[0];
            }) - events.begin();
            if (j < i) {
                dp[i] = max(dp[i], dp[j - 1] + events[i][2]);
            }
        }
        return dp.back();
    }
};