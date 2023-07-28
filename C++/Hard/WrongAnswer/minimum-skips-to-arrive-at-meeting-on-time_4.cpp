class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n, vector<int>(n + 1, INT_MAX));
        dp[0][0] = (dist[0] + speed - 1) / speed;
        dp[0][1] = (dist[0] * 2 + speed - 1) / speed;
        for (int i = 1; i < n; i++) {
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