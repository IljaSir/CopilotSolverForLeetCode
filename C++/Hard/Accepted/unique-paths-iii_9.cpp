class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int start_x, start_y, end_x, end_y;
        int empty_count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                } else if (grid[i][j] == 2) {
                    end_x = i;
                    end_y = j;
                } else if (grid[i][j] == 0) {
                    empty_count++;
                }
            }
        }
        return dfs(grid, start_x, start_y, end_x, end_y, empty_count);
    }
    int dfs(vector<vector<int>>& grid, int x, int y, int end_x, int end_y, int empty_count) {
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size() || grid[x][y] == -1) {
            return 0;
        }
        if (x == end_x && y == end_y) {
            return empty_count == -1;
        }
        grid[x][y] = -1;
        int ret = dfs(grid, x + 1, y, end_x, end_y, empty_count - 1) +
                  dfs(grid, x - 1, y, end_x, end_y, empty_count - 1) +
                  dfs(grid, x, y + 1, end_x, end_y, empty_count - 1) +
                  dfs(grid, x, y - 1, end_x, end_y, empty_count - 1);
        grid[x][y] = 0;
        return ret;
    }
};