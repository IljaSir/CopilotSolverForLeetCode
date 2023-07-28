class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int m = grid1.size();
        int n = grid1[0].size();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    bool dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int i, int j) {
        if (i < 0 || i >= grid2.size() || j < 0 || j >= grid2[0].size() || grid2[i][j] == 0) {
            return true;
        }
        bool res = true;
        if (grid1[i][j] == 0) {
            res = false;
        }
        grid2[i][j] = 0;
        res = res && dfs(grid1, grid2, i + 1, j);
        res = res && dfs(grid1, grid2, i - 1, j);
        res = res && dfs(grid1, grid2, i, j + 1);
        res = res && dfs(grid1, grid2, i, j - 1);
        return res;
    }
};