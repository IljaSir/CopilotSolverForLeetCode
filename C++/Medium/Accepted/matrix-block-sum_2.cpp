class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> sum(m+1, vector<int>(n+1, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sum[i+1][j+1] = mat[i][j] + sum[i][j+1] + sum[i+1][j] - sum[i][j];
            }
        }
        vector<vector<int>> ans(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = max(0, i-k);
                int y1 = max(0, j-k);
                int x2 = min(m-1, i+k);
                int y2 = min(n-1, j+k);
                ans[i][j] = sum[x2+1][y2+1] - sum[x2+1][y1] - sum[x1][y2+1] + sum[x1][y1];
            }
        }
        return ans;
    }
};