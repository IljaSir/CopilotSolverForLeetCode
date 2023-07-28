class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        
        int n = grid.size();
        queue<pair<int, int>> q;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.push({i, j});
                }
            }
        }
        if (q.size() == 0 || q.size() == n * n) {
            return -1;
        }
        int res = -1;
        while (!q.empty()) {
            int size = q.size();
            ++res;
            for (int i = 0; i < size; ++i) {
                auto p = q.front();
                q.pop();
                int x = p.first, y = p.second;
                if (x > 0 && grid[x - 1][y] == 0) {
                    grid[x - 1][y] = 1;
                    q.push({x - 1, y});
                }
                if (x < n - 1 && grid[x + 1][y] == 0) {
                    grid[x + 1][y] = 1;
                    q.push({x + 1, y});
                }
                if (y > 0 && grid[x][y - 1] == 0) {
                    grid[x][y - 1] = 1;
                    q.push({x, y - 1});
                }
                if (y < n - 1 && grid[x][y + 1] == 0) {
                    grid[x][y + 1] = 1;
                    q.push({x, y + 1});
                }
            }
        }
        return res;
    }
};