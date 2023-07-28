class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int m = grid1.size(), n = grid1[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    bool flag = true;
                    dfs(grid1, grid2, visited, i, j, flag);
                    res += flag;
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, vector<vector<bool>>& visited, int i, int j, bool& flag) {
        if (i < 0 || i >= grid1.size() || j < 0 || j >= grid1[0].size() || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (grid1[i][j] == 0) {
            flag = false;
        }
        dfs(grid1, grid2, visited, i + 1, j, flag);
        dfs(grid1, grid2, visited, i - 1, j, flag);
        dfs(grid1, grid2, visited, i, j + 1, flag);
        dfs(grid1, grid2, visited, i, j - 1, flag);
    }
};