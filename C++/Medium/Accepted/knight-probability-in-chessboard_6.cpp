class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        vector<vector<double>> dp(n, vector<double>(n, 0));
        dp[row][column] = 1;
        vector<int> dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        vector<int> dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i = 0; i < k; i++) {
            vector<vector<double>> dp2(n, vector<double>(n, 0));
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int j = 0; j < 8; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        dp2[nx][ny] += dp[x][y] / 8.0;
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                ans += dp[x][y];
            }
        }
        return ans;
    }
};