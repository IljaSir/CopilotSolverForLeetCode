class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> sizes(n * n + 2, 0);
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int color = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                int size = 0;
                queue<pair<int, int>> q;
                q.push({i, j});
                grid[i][j] = color;
                while (!q.empty()) {
                    auto [x, y] = q.front(); q.pop();
                    size++;
                    for (auto& dir : dirs) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != 1) continue;
                        grid[nx][ny] = color;
                        q.push({nx, ny});
                    }
                }
                sizes[color] = size;
                color++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) continue;
                unordered_set<int> seen;
                int size = 1;
                for (auto& dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || seen.count(grid[x][y]) || grid[x][y] == 0) continue;
                    seen.insert(grid[x][y]);
                    size += sizes[grid[x][y]];
                }
                res = max(res, size);
            }
        }
        return res == 0 ? n * n : res;
    }
};