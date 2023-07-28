class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int m = grid1.size();
        int n = grid1[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1 && visited[i][j] == 0) {
                    if (dfs(grid1, grid2, visited, i, j)) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }
    
    bool dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, vector<vector<int>>& visited, int r, int c) {
        int m = grid1.size();
        int n = grid1[0].size();
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return true;
        }
        if (grid2[r][c] == 0 || visited[r][c] == 1) {
            return true;
        }
        visited[r][c] = 1;
        if (grid1[r][c] == 0) {
            return false;
        }
        return dfs(grid1, grid2, visited, r-1, c) && dfs(grid1, grid2, visited, r+1, c) && dfs(grid1, grid2, visited, r, c-1) && dfs(grid1, grid2, visited, r, c+1);
    }
};