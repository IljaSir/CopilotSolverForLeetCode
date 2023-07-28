class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int m = grid1.size();
        int n = grid1[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    bool isSubIsland = true;
                    dfs(grid1, grid2, i, j, visited, isSubIsland);
                    if (isSubIsland) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    void dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int i, int j, vector<vector<bool>>& visited, bool& isSubIsland) {
        if (i < 0 || i >= grid1.size() || j < 0 || j >= grid1[0].size()) {
            return;
        }
        if (grid2[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (grid1[i][j] == 0) {
            isSubIsland = false;
        }
        dfs(grid1, grid2, i + 1, j, visited, isSubIsland);
        dfs(grid1, grid2, i - 1, j, visited, isSubIsland);
        dfs(grid1, grid2, i, j + 1, visited, isSubIsland);
        dfs(grid1, grid2, i, j - 1, visited, isSubIsland);
    }
};