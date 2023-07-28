class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        if (m == 1 || n == 1) return true;
        int flag = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    if (i == 0 && j == 0) continue;
                    if (i == m - 1 && j == n - 1) continue;
                    if (i == 0 || j == 0) {
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if (flag == 0) return false;
        return true;
    }
    bool isPossibleToCutPath2(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if (m == 1 || n == 1) return true;
        int flag = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    if (i == 0 && j == 0) continue;
                    if (i == m - 1 && j == n - 1) continue;
                    if (i == m - 1 || j == n - 1) {
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if (flag == 0) return false;
        return true;
    }
};