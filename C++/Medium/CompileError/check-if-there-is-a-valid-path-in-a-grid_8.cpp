class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> path(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({0, 0});
        path[0][0] = 1;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1)
                return true;
            if (grid[x][y] == 1) {
                if (y - 1 >= 0 && path[x][y - 1] == 0 && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6)) {
                    q.push({x, y - 1});
                    path[x][y - 1] = 1;
                }
                if (y + 1 < n && path[x][y + 1] == 0 && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5)) {
                    q.push({x, y + 1});
                    path[x][y + 1] = 1;
                }
            } else if (grid[x][y] == 2) {
                if (x - 1 >= 0 && path[x - 1][y] == 0 && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4)) {
                    q.push({x - 1, y});
                    path[x - 1][y] = 1;
                }
                if (x + 1 < m && path[x + 1][y] == 0 && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6)) {
                    q.push({x + 1, y});
                    path[x + 1][y] = 1;
                }
            } else if (grid[x][y] == 3) {
                if (y -
    }
};