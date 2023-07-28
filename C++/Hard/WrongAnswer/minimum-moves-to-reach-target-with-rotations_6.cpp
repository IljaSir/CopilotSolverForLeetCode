class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        queue<pair<int, int>> q;
        q.push({0, 0});
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto [x, y] = q.front(); q.pop();
                if (x == n - 1 && y == n - 2) return steps;
                if (x + 1 < n && grid[x + 1][y] == 0) {
                    grid[x + 1][y] = 1;
                    q.push({x + 1, y});
                }
                if (y + 1 < n && grid[x][y + 1] == 0) {
                    grid[x][y + 1] = 1;
                    q.push({x, y + 1});
                }
                if (x + 1 < n && y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && grid[x + 1][y] == 0) {
                    grid[x + 1][y + 1] = 1;
                    q.push({x, y + 1});
                }
                if (x + 1 < n && y + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && grid[x][y + 1] == 0) {
                    grid[x + 1][y + 1] = 1;
                    q.push({x + 1, y});
                }
            }
            steps++;
        }
        return -1;
    }
};