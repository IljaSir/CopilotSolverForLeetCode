class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        if (m == 1 && n == 1) return 0;
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto [i, j] = q.front();
            q.pop();
            if (i == m - 1 && j == n - 1) return dist[i][j];
            for (int di = -1; di <= 1; ++di) {
                for (int dj = -1; dj <= 1; ++dj) {
                    if (di == 0 && dj == 0) continue;
                    if (di * dj != 0) continue;
                    int ni = i + di;
                    int nj = j + dj;
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                    int nd = dist[i][j] + 1;
                    if (grid[ni][nj] == 1) {
                        nd++;
                    }
                    if (nd < dist[ni][nj] && nd <= k) {
                        dist[ni][nj] = nd;
                        q.push({ni, nj});
                    }
                }
            }
        }
        return -1;
    }
};