class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        dfs(0, 0, grid, visited);
        return !visited[m-1][n-1];
    }
    void dfs(int i, int j, vector<vector<int>>& grid, vector<vector<bool>>& visited) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        dfs(i+1, j, grid, visited);
        dfs(i, j+1, grid, visited);
    }
    bool disconnectPath(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 || i == m-1 && j == n-1)
                    continue;
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isPossibleToCutPath(grid))
                        return true;
                    grid[i][j] = 1;
                }
            }
        }
        return false;
    }
};