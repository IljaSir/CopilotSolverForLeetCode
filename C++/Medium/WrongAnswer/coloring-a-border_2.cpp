class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        int oldColor = grid[row][col];
        if (oldColor == color) return grid;
        queue<pair<int, int>> q;
        q.push({row, col});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != oldColor) continue;
            grid[x][y] = -1;
            q.push({x - 1, y});
            q.push({x + 1, y});
            q.push({x, y - 1});
            q.push({x, y + 1});
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == -1) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1 || grid[i - 1][j] != oldColor || grid[i + 1][j] != oldColor || grid[i][j - 1] != oldColor || grid[i][j + 1] != oldColor) {
                        grid[i][j] = color;
                    }
                }
            }
        }
        return grid;
    }
};