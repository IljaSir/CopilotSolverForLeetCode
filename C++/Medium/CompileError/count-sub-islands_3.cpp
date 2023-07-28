class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        
        int n = grid1.size();
        int m = grid1[0].size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j]) {
                    ans += dfs(grid1, grid2, i, j);
                }
            }
        }
        return ans;
    }
};