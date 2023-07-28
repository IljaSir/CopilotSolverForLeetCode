class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](const auto &a, const auto &b) {
            return a[1] < b[1];
        });
        int N = events.size();
        vector<int> dp(N, 0);
        dp[0] = events[0][2];
        for (int i = 1; i < N; ++i) {
            int j = i - 1;
            while (j >= 0 && events[j][1] >= events[i][0]) {
                --j;
            }
            if (j >= 0) {
                dp[i] = max(dp[j] + events[i][2], dp[i - 1]);
            } else {
                dp[i] = max(events[i][2], dp[i - 1]);
            }
        }
        return dp.back();
    }
    int maxValue(vector<vector<int>>& events, int k) {
        sort(events.begin(), events.end(), [](const auto &a, const auto &b) {
            return a[0] < b[0];
        });
        int N = events.size();
        vector<vector<int>> dp(N, vector<int>(k + 1, 0));
        for (int i = 0; i < N; ++i) {
            int j = i - 1;
            while (j >= 0 && events[j][1] >= events[i][0]) {
                --j;
            }
            if (j >= 0) {
                dp[i][1] = max(dp[j][0] + events[i][2], dp[i - 1][1]);
            } else {
                dp[i][1] = events[i][2];
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 2; j <= k; ++j) {
                int l = i - 1;
                while (l >= 0 && events[l][1] >= events[i][0]) {
                    --l;
                }
                if (l >= 0) {
                    dp[i][j] = max(dp[l][j - 1] + events[i][2], dp[i - 1][j]);
                } else {
                    dp[i][j] = max(events[i][2], dp[i - 1][j]);
                }
            }
        }
        return dp.back
    }
};