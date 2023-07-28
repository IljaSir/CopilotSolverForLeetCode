class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1]);
                }
                int t = (dist[i - 1] + speed - 1) / speed;
                if (dp[i - 1][j] != INT_MAX) {
                    dp[i][j] = min(dp[i][j], (dp[i - 1][j] + t - 1) / t * t);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] <= (long long)hoursBefore * speed) {
                return i;
            }
        }
        return -1;
    }
};