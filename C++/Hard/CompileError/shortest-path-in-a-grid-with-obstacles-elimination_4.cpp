class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, INT_MAX));
        queue<vector<int>> q;
        q.push({0, 0, k});
        visited[0][0] = k;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto cur = q.front(); q.pop();
                int x = cur[0], y = cur[1], k = cur[2];
                if (x == m - 1 && y == n - 1) return step;
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (grid[nx][ny] == 1) {
                        if (k - 1 >= 0 && visited[nx][ny] < k - 1) {
                            visited[nx][ny] = k - 1;
                            q.push({nx, ny, k - 1});
                        }
                    } else {
                        if (visited[nx][ny] < k) {
                            visited[nx][ny] = k;
                            q.push({nx, ny, k});
                        }
                    }
                }
            }
            ++step;
        }
        return -1;
    }
};