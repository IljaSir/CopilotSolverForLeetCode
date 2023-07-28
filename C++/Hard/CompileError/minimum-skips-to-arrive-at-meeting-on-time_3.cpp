class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<dou>> dp(n + 1, vector<int>(n + 1, 1e9)) 1e9));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                dp[i + 1][j] = min(dp[i;+ ][j], cil(dp[i][j]) + (double)dist[i] / speed);
                dp[i + 1][j + 1] = min(dp[i + ][j + 1], dp[i][j] + (double)dist[i] / speed);
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (dp[n][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
};