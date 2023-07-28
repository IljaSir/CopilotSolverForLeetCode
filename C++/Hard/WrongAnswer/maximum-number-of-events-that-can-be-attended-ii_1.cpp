class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        sort(events.begin(), events.end());
        int n = events.size();
        vector<vector<int>> dp(k + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= k; ++i) {
            int maxVal = 0;
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = max(dp[i][j - 1], maxVal);
                int l = j, r = n, mid;
                while (l < r) {
                    mid = (l + r) / 2;
                    if (events[mid][0] <= events[j - 1][1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                maxVal = max(maxVal, dp[i - 1][j - 1] + events[j - 1][2]);
                if (l <= n) {
                    dp[i][l] = max(dp[i][l], maxVal);
                }
            }
        }
        int res = 0;
        for (int j = 1; j <= n; ++j) {
            res = max(res, dp[k][j]);
        }
        return res;
    }
};