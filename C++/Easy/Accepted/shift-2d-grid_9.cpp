class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int k1 = k % (m * n);
        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j + k1) % (m * n);
                res[idx / n][idx % n] = grid[i][j];
            }
        }
        return res;
    }
};