class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        int n = events.size();
        sort(events.begin(), events.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });
        vector<vector<int>> dp(n, vector<int>(k + 1, 0));
        dp[0][1] = events[0][2];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j]);
                int l = 0, r = i - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (events[m][1] < events[i][0]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                dp[i][j] = max(dp[i][j], dp[l - 1][j - 1] + events[i][2]);
            }
        }
        int res = 0;
        for (int j = 1; j <= k; ++j) {
            res = max(res, dp[n - 1][j]);
        }
        return res;
    }
};