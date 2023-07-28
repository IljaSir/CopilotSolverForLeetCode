class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = 1;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1)
                return true;
            if (grid[x][y] == 1) {
                if (y - 1 >= 0 && visited[x][y - 1] == 0 && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6)) {
                    q.push({x, y - 1});
                    visited[x][y - 1] = 1;
                }
                if (y + 1 < n && visited[x][y + 1] == 0 && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5)) {
                    q.push({x, y + 1});
                    visited[x][y + 1] = 1;
                }
            }
            if (grid[x][y] == 2) {
                if (x - 1 >= 0 && visited[x - 1][y] == 0 && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4)) {
                    q.push({x - 1, y});
                    visited[x - 1][y] = 1;
                }
                if (x + 1 < m && visited[x + 1][y] == 0 && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6)) {
                    q.push({x + 1, y});
                    visited[x + 1][y] = 1;
                }
            }
            if (grid[x][y] == 3) {
                if (y - 1
    }
};