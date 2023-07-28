class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        queue<vector<int>> q;
        q.push({0, 0, 0, 0});
        vector<vector<vector<int>>> visited(n, vector<vector<int>>(n, vector<int>(2, 0)));
        visited[0][0][0] = 1;
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto cur = q.front(); q.pop();
                int x = cur[0], y = cur[1], d = cur[2], s = cur[3];
                if (x == n - 1 && y == n - 2 && d == 0) {
                    return s;
                }
                if (x < n - 1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && visited[x + 1][y][d] == 0) {
                    visited[x + 1][y][d] = 1;
                    q.push({x + 1, y, d, s + 1});
                }
                if (y < n - 1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && visited[x][y + 1][d] == 0) {
                    visited[x][y + 1][d] = 1;
                    q.push({x, y + 1, d, s + 1});
                }
                if (d == 0 && x < n - 1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && visited[x][y][1] == 0) {
                    visited[x][y][1] = 1;
                    q.push({x, y, 1, s + 1});
                }
                if (d == 1 && y < n - 1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && visited[x][y][0] == 0) {
                    visited[x][y][0] = 1;
                    q.push({x, y, 0, s + 1});
                }
    }
};