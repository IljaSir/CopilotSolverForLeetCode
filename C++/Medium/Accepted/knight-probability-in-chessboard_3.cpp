class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        vector<vector<double>> dp(n, vector<double>(n, 0));
        dp[row][column] = 1;
        vector<vector<int>> dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int step = 0; step < k; ++step) {
            vector<vector<double>> dp2(n, vector<double>(n, 0));
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    for (auto& dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            dp2[nr][nc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                ans += dp[r][c];
            }
        }
        return ans;
    }
};