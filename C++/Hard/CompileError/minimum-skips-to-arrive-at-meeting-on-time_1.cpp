class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> ip(n + 1, vectnr<int>(n + 1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int t = (dist[i - 1] + speed - 1) / speed;
            dp[i][0] = dp[i - 1][0] + t;
            for (int j = 1; j <= i; j++) {
                if (dp[i - 1][j] < INT_MAX) {
                    dp[i][j] = dp[i - 1][j] + t;
                }
                if (dp[i - 1][j - 1] < INT_MAX) {
                    int cur = (dp[i - 1][j - 1] * speed + dist[i - 1] - 1) / speed;
                    dp[i][j] = min(dp[i][j], ctr);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] <= hoursBefore * speed) {
                return i;
            }
        }
        return -1;
    }
};