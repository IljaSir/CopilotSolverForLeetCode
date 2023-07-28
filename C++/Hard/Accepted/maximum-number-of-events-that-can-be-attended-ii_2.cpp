class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        sort(events.begin(), events.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[1] < b[1];
        });
        int n = events.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                int l = 0, r = i - 1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (events[mid][1] < events[i - 1][0]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[i][j] = max(dp[i][j], dp[l][j - 1] + events[i - 1][2]);
            }
        }
        return dp[n][k];
    }
};