class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        vector<int> onesRow(m, 0);
        vector<int> onesCol(n, 0);
        vector<int> zerosRow(m, 0);
        vector<int> zerosCol(n, 0);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++onesRow[i];
                    ++onesCol[j];
                } else {
                    ++zerosRow[i];
                    ++zerosCol[j];
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return ans;
    }
};