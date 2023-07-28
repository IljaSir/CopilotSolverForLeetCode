class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int left = 0, right = n * n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    bool check(vector<vector<int>>& grid, int t) {
        int n = grid.size();
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        int dx[4] = {-1, 1, 0, 0};
        int dy[4] = {0, 0, -1, 1};
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && max(dist[x][y], grid[nx][ny]) <= t && max(dist[nx][ny], grid[nx][ny]) > t) {
                    dist[nx][ny] = max(dist[x][y], grid[nx][ny]);
                    q.push({nx, ny});
                }
            }
        }
        return dist[n - 1][n - 1] <= t;
    }
};