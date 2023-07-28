class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int n = buses.size(), m = passengers.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (passengers[j - 1] <= buses[i - 1] && j - capacity - 1 >= 0) {
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - capacity - 1] + passengers[j - 1]);
                }
                dp[i][j] = max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
};