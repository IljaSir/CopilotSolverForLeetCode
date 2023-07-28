class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<vector<int>> dp(n, vector<int>(3, 1e9));
        dp[0][1] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] != j + 1) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j]);
                }
            }
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] != j + 1) {
                    for (int k = 0; k < 3; ++k) {
                        if (j != k) {
                            dp[i][j] = min(dp[i][j], dp[i][k] + 1);
                        }
                    }
                }
            }
        }
        return min({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]});
    }
};