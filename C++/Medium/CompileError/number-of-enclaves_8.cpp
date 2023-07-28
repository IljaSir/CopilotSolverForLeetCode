class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<int>> visited(rows, vector<int>(cols, 0));
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid, visited);
            if (grid[i][cols - 1] == 1) dfs(i, cols - 1, grid, visited);
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid, visited);
            if (grid[rows - 1][j] == 1) dfs(rows - 1, j, grid, visited);
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
};