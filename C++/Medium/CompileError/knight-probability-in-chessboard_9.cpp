class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        double dp[25][25][101];
        memset(dp, 0, sizeof(dp));
        dp[row][column][0] = 1;
        for (int i = 0; i < k; ++i) {
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    for (int j = 0; j < 8; ++j) {
                        int nr = r + dr[j];
                        int nc = c + dc[j];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            dp[nr][nc][i+1] += dp[r][c][i] / 8;
                        }
                    }
                }
            }
        }
        double ans = 0;
        for (int i = 0; i < k; ++i) {
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    ans += dp[r][c][i];
                }
            }
        }
        return ans;
    }
};