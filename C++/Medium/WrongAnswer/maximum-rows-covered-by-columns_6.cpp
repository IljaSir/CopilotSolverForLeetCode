class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size(), n = matrix[0].size();
        vector<int> rows(m, 0);
        int res = 0;
        for (int i = 0; i < (1 << n); ++i) {
            if (__builtin_popcount(i) == numSelect) {
                fill(rows.begin(), rows.end(), 0);
                for (int j = 0; j < n; ++j) {
                    if (i & (1 << j)) {
                        for (int k = 0; k < m; ++k) {
                            rows[k] += matrix[k][j];
                        }
                    }
                }
                res = max(res, *max_element(rows.begin(), rows.end()));
            }
        }
        return res;
    }
};