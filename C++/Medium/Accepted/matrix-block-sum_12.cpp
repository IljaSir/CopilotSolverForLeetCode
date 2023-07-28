class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        
        int M = mat.size();
        int N = mat[0].size();
        vector<vector<int>> ans(M, vector<int>(N, 0));
        vector<vector<int>> sum(M+1, vector<int>(N+1, 0));
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                int r1 = max(1, i-k);
                int c1 = max(1, j-k);
                int r2 = min(M, i+k);
                int c2 = min(N, j+k);
                ans[i-1][j-1] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }
        return ans;
    }
};