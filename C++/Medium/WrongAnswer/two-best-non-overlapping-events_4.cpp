class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](vector<int>& a, vector<int>& b) {
            return a[1] < b[1];
        });
        int n = events.size();
        vector<int> dp(n, 0);
        dp[0] = events[0][2];
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            int mid;
            while (l < r) {
                mid = l + (r - l) / 2;
                if (events[mid][1] < events[i][0]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (events[l][1] >= events[i][0]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = max(dp[i - 1], dp[l] + events[i][2]);
            }
        }
        return dp[n - 1];
    }
};