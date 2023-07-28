class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        int n = events.size();
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            dp[i] = events[i][2];
        }
        for (int i = 1; i < k; ++i) {
            vector<int> dp2(n, 0);
            for (int j = 0; j < n; ++j) {
                int start = events[j][0];
                int end = events[j][1];
                int value = events[j][2];
                int l = 0;
                int r = j;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (events[mid][1] < start) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                int prev = 0;
                if (l > 0) {
                    prev = dp[l - 1];
                }
                dp2[j] = max(dp2[j], prev + value);
                if (j > 0) {
                    dp2[j] = max(dp2[j], dp2[j - 1]);
                }
            }
            dp = dp2;
        }
        return dp[n - 1];
    }
};