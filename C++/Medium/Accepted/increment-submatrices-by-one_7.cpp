class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        
        vector<vector<int>> mat(n, vector<int>(n));
        for (int i = 0; i < queries.size(); ++i) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            mat[r1][c1] += 1;
            if (r2 + 1 < n) {
                mat[r2 + 1][c1] -= 1;
            }
            if (c2 + 1 < n) {
                mat[r1][c2 + 1] -= 1;
            }
            if (r2 + 1 < n && c2 + 1 < n) {
                mat[r2 + 1][c2 + 1] += 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    mat[i][j] += mat[i - 1][j];
                }
                if (j > 0) {
                    mat[i][j] += mat[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    mat[i][j] -= mat[i - 1][j - 1];
                }
            }
        }
        return mat;
    }
};