class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
        vector<vector<vector<int>>> neighbors = {
            {{0, 1}, {0, -1}}, // 0
            {{1, 0}, {-1, 0}}, // 1
            {{0, 1}, {-1, 0}}, // 2
            {{0, -1}, {-1, 0}}, // 3
            {{0, 1}, {1, 0}}, // 4
            {{0, -1}, {1, 0}}, // 5
        };
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1) return true;
            int type = grid[x][y] - '0';
            for (auto &dir : neighbors[type]) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int ntype = grid[nx][ny] - '0';
                    for (auto &ndir : neighbors[ntype]) {
                        if (ndir[0] == -dir[0] && ndir[1] == -dir[1]) {
                            visited[nx][ny] = true;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        return false;
    }
};