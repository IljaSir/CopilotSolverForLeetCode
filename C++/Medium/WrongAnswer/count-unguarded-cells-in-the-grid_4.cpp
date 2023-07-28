class Solution {
public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        
        int ans = 0;
        vector<vector<int>> grid(m, vector<int>(n, 0));
        for (auto& guard : guards) {
            int x = guard[0], y = guard[1];
            grid[x][y] = 1;
            for (int i = x - 1; i >= 0; --i) {
                if (grid[i][y] == 2) break;
                grid[i][y] = 1;
            }
            for (int i = x + 1; i < m; ++i) {
                if (grid[i][y] == 2) break;
                grid[i][y] = 1;
            }
            for (int j = y - 1; j >= 0; --j) {
                if (grid[x][j] == 2) break;
                grid[x][j] = 1;
            }
            for (int j = y + 1; j < n; ++j) {
                if (grid[x][j] == 2) break;
                grid[x][j] = 1;
            }
        }
        for (auto& wall : walls) {
            int x = wall[0], y = wall[1];
            grid[x][y] = 2;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) ++ans;
            }
        }
        return ans;
    }
};