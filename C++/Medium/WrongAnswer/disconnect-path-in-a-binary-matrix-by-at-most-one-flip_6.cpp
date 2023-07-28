class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> path(m, vector<int>(n, 0));
        path[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (grid[i][j] == 0) continue;
                if (i > 0 && path[i - 1][j] == 1) path[i][j] = 1;
                if (j > 0 && path[i][j - 1] == 1) path[i][j] = 1;
            }
        }
        return path[m - 1][n - 1] == 0;
    }
    bool isPossibleToCutPath2(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> path(m, vector<int>(n, 0));
        path[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (grid[i][j] == 0) continue;
                if (i > 0 && path[i - 1][j] == 1) path[i][j] = 1;
                if (j > 0 && path[i][j - 1] == 1) path[i][j] = 1;
            }
        }
        if (path[m - 1][n - 1] == 1) return true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 0;
                if (isPossibleToCutPath(grid)) return true;
                grid[i][j] = 1;
            }
        }
        return false;
    }
};