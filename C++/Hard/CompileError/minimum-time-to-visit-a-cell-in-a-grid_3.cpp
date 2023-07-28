class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        dp[0][0] = 0;
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0});
        vector<int> dx = {0, 1, 0, -1};
        vector<int> dy = {1, 0, -1, 0};
        while (!pq.empty()) {
            auto [t, x, y] = pq.top();
            pq.pop();
            if (dp[x][y] < t) continue;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nt = max(t, grid[nx][ny]);
                if (dp[nx][ny] <= nt) continue;
                dp[nx][ny] = nt;
                pq.push({nt, nx, ny});
            }
        }
        return dp[m - 1][n - 1] == INT_MAX ? -1 : dp[m - 1][n - 1];
    }
};