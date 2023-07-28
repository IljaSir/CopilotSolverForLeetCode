class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        while (!q.empty()) {
            int r = q.front().first, c = q.front().second;
            q.pop();
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            if (r + 1 < m && !visited[r + 1][c] && grid[r + 1][c] == 1) {
                visited[r + 1][c] = true;
                q.push({r + 1, c});
            }
            if (c + 1 < n && !visited[r][c + 1] && grid[r][c + 1] == 1) {
                visited[r][c + 1] = true;
                q.push({r, c + 1});
            }
        }
        return false;
    }
    bool checkPath(vector<vector<int>>& grid, int r, int c) {
        grid[r][c] = 1 - grid[r][c];
        bool res = isPossibleToCutPath(grid);
        grid[r][c] = 1 - grid[r][c];
        return res;
    }
    bool disconnectPath(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        bool res = checkPath(grid, 0, 0);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0 || i == m - 1 && j == n - 1) {
                    continue;
                }
                if (grid[i][j] == 1 && checkPath(grid, i, j)) {
                    return true;
                }
            }
        }
        return res;
    }
};