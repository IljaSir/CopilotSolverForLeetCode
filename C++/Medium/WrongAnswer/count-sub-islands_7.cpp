class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int m = grid1.size(), n = grid1[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, visited, i, j, m, n)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    
    bool dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, vector<vector<bool>>& visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        if (grid1[i][j] == 0) {
            return false;
        }
        bool res = true;
        res &= dfs(grid1, grid2, visited, i - 1, j, m, n);
        res &= dfs(grid1, grid2, visited, i + 1, j, m, n);
        res &= dfs(grid1, grid2, visited, i, j - 1, m, n);
        res &= dfs(grid1, grid2, visited, i, j + 1, m, n);
        return res;
    }
};