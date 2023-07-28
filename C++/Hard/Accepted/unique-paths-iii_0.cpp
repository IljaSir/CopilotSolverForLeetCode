class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int start_x = 0;
        int start_y = 0;
        int end_x = 0;
        int end_y = 0;
        int zero_cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                } else if (grid[i][j] == 2) {
                    end_x = i;
                    end_y = j;
                } else if (grid[i][j] == 0) {
                    zero_cnt++;
                }
            }
        }
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        return dfs(grid, visited, start_x, start_y, end_x, end_y, zero_cnt);
    }
    
    int dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int x, int y, int end_x, int end_y, int zero_cnt) {
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size() || grid[x][y] == -1 || visited[x][y]) {
            return 0;
        }
        if (x == end_x && y == end_y) {
            return zero_cnt == 0 ? 1 : 0;
        }
        visited[x][y] = true;
        int ans = 0;
        ans += dfs(grid, visited, x - 1, y, end_x, end_y, zero_cnt - (grid[x][y] == 0));
        ans += dfs(grid, visited, x + 1, y, end_x, end_y, zero_cnt - (grid[x][y] == 0));
        ans += dfs(grid, visited, x, y - 1, end_x, end_y, zero_cnt - (grid[x][y] == 0));
        ans += dfs(grid, visited, x, y + 1, end_x, end_y, zero_cnt - (grid[x][y] == 0));
        visited[x][y] = false;
        return ans;
    }
};