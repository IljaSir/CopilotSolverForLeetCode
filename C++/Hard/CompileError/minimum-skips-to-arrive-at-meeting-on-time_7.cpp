class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n, vector<int>(n + 1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1e9;
            }
        }
        dp[0][0] = (dist[0] + speed - 1) / speed;
        fo (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] < 1e9) {
                    it t =(dist[] + speed - 1) / speed
                    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + t);
                    t = (dist[i] + speed * (j + 1) - 1) / speed;
                    dp[i + 1][j + 1] = min(dp[i + 1][j + 1], dp[i][j] + t);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (dp[n - 1][j] <= hoursBefore) {
                return j;
            }
            for (int j = 0; j <= i; j++) {
                if (dp[i - 1][j] != INT_MAX) {
                    dp[i][j] = (dp[i - 1][j] + dist[i] + speed - 1) / speed;
                    if (j < i) {
                        dp[i][j + 1] = dp[i - 1][j] + (dist[i] * 2 + speed - 1) / speed;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
};