class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int val = grid[row][col];
        queue<pair<int, int>> q;
        q.push({row, col});
        visited[row][col] = 1;
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            int cnt = 0;
            for (auto& dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                    grid[x][y] = color;
                    continue;
                }
                if (grid[xx][yy] != val) {
                    grid[x][y] = color;
                    continue;
                }
                if (!visited[xx][yy]) {
                    visited[xx][yy] = 1;
                    q.push({xx, yy});
                }
            }
        }
        return grid;
    }
};