class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int m = grid[0].size();
        vector<vector<int>> dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int level = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [x, y] = q.front();
                q.pop();
                if (x == n - 1 && y == n - 1) {
                    return level;
                }
                for (auto& dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
                        q.push({nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
            ++level;
        }
        return -1;
    }
};