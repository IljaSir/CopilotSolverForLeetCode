class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        sort(events.begin(), events.end());
        vector<int> dp(events.size(), 0);
        dp[0] = events[0][2];
        for (int i = 1; i < events.size(); i++) {
            dp[i] = events[i][2];
            for (int j = 0; j < i; j++) {
                if (events[j][1] < events[i][0]) {
                    dp[i] = max(dp[i], dp[j] + events[i][2]);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};