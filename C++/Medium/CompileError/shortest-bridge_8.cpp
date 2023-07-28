class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int island = 1;
        vector<vector<int>> islands;
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vector<int> island;
                    q.push({i, j});
                    while (!q.empty()) {
                        auto [x, y] = q.front();
                        q.pop();
                        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                            continue;
                        }
                        grid[x][y] = island;
                        island.push_back(x * m + y);
                        for (auto& dir : dirs) {
                            q.push({x + dir[0], y + dir[1]});
                        }
                    }
                    islands.push_back(island);
                    island++;
                }
            }
        }
        int ans = 0;
        q.push({islands[0][0] / m, islands[0][0] % m});
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();
                if (grid[x][y] == 2) {
                    return ans - 1;
                }
                for (auto& dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 1) {
                        continue;
                    }
                    grid[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
            ans++;
        }
        return ans;
    }
};