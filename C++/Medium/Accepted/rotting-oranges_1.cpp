class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int, int>> q;
        int fresh = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                } else if (grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int time = 0;
        while (!q.empty()) {
            ++time;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [x, y] = q.front();
                q.pop();
                if (x > 0 && grid[x - 1][y] == 1) {
                    --fresh;
                    grid[x - 1][y] = 2;
                    q.push({x - 1, y});
                }
                if (x < m - 1 && grid[x + 1][y] == 1) {
                    --fresh;
                    grid[x + 1][y] = 2;
                    q.push({x + 1, y});
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    --fresh;
                    grid[x][y - 1] = 2;
                    q.push({x, y - 1});
                }
                if (y < n - 1 && grid[x][y + 1] == 1) {
                    --fresh;
                    grid[x][y + 1] = 2;
                    q.push({x, y + 1});
                }
            }
        }
        return fresh == 0 ? time - 1 : -1;
    }
};