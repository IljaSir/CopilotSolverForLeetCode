class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(n, -1)));
        return max(0, dfs(grid, dp, 0, 0, 0));
    }
};