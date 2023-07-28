class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newj = (j + k) % n;
                int newi = (i + (j + k) / n) % m;
                res[newi][newj] = grid[i][j];
            }
        }
        return res;
    }
};