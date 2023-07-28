class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });
        vector<int> dp(events.size() + 1, 0);
        for (int i = 0; i < events.size(); ++i) {
            int j = i - 1;
            while (j >= 0 && events[j][1] >= events[i][0]) {
                --j;
            }
            dp[i + 1] = max(dp[i], events[i][2] + (j >= 0 ? dp[j + 1] : 0));
        }
        return dp.back();
    }
};