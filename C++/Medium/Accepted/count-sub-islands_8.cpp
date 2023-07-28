class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int m = grid1.size();
        int n = grid1[0].size();
        int res = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (grid2[i][j]) {
                    res += dfs(grid1, grid2, i, j);
                }
            }
        }
        return res;
    }
    int dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int i, int j) {
        if (i < 0 || i >= grid1.size() || j < 0 || j >= grid1[0].size() || !grid2[i][j]) {
            return 1;
        }
        grid2[i][j] = 0;
        int res = grid1[i][j];
        res &= dfs(grid1, grid2, i - 1, j);
        res &= dfs(grid1, grid2, i + 1, j);
        res &= dfs(grid1, grid2, i, j - 1);
        res &= dfs(grid1, grid2, i, j + 1);
        return res;
    }
};