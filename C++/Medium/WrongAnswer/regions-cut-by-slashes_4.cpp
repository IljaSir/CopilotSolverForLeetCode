class Solution {
public:
    int regionsBySlashes(vector<string>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int res = 0;
        vector<vector<int>> visited(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    dfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(vector<string>& grid, vector<vector<int>>& visited, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        if (grid[i][j] == '/') {
            dfs(grid, visited, i, j + 1);
            dfs(grid, visited, i + 1, j);
        } else if (grid[i][j] == '\\') {
            dfs(grid, visited, i, j - 1);
            dfs(grid, visited, i - 1, j);
        } else {
            dfs(grid, visited, i, j + 1);
            dfs(grid, visited, i + 1, j);
            dfs(grid, visited, i, j - 1);
            dfs(grid, visited, i - 1, j);
        }
    }
};