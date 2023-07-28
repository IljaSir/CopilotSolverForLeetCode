class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[r<int>> sum(m + 1, vector<int>(n + 1, 0));
        vector<vector<int>> ans(m, vector<int>(n, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x1 = max(1, i - k), y1 = max(1, j - k);
                int x2 = min(m, i + k), y2 = min(n, j + k);
                ans[i - 1][j - 1] = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            }
        }
        return ans;
    }
};