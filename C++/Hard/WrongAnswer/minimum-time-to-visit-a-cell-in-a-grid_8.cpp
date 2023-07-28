class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int t = 0;
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));
        dp[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            if (x - 1 >= 0) {
                int t1 = max(dp[x][y], grid[x - 1][y]);
                if (t1 < dp[x - 1][y]) {
                    dp[x - 1][y] = t1;
                    q.push({x - 1, y});
                }
            }
            if (x + 1 < n) {
                int t1 = max(dp[x][y], grid[x + 1][y]);
                if (t1 < dp[x + 1][y]) {
                    dp[x + 1][y] = t1;
                    q.push({x + 1, y});
                }
            }
            if (y - 1 >= 0) {
                int t1 = max(dp[x][y], grid[x][y - 1]);
                if (t1 < dp[x][y - 1]) {
                    dp[x][y - 1] = t1;
                    q.push({x, y - 1});
                }
            }
            if (y + 1 < m) {
                int t1 = max(dp[x][y], grid[x][y + 1]);
                if (t1 < dp[x][y + 1]) {
                    dp[x][y + 1] = t1;
                    q.push({x, y + 1});
                }
            }
        }
        return dp[n - 1][m - 1] == INT_MAX ? -1 : dp[n - 1][m - 1];
    }
};