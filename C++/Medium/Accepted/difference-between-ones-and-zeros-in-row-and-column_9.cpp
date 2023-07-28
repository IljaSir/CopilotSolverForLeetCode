class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> rowSum(m, 0);
        vector<int> colSum(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }
        
        vector<vector<int>> ans(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = rowSum[i] + colSum[j] - (n - colSum[j]) - (m - rowSum[i]);
            }
        }
        return ans;
    }
};