class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        vector<vector<int>> dp(events.size() + 1, vector<int>(k + 1, 0));
        for (int i = 1; i <= events.size(); ++i) {
            for (int j = 1; j <= k; ++j) {
                int left = 0, right = i - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (events[mid][1] < events[i - 1][0]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[i][j] = max(dp[i - 1][j], dp[left][j - 1] + events[i - 1][2]);
            }
        }
        return dp[events.size()][k];
    }
};