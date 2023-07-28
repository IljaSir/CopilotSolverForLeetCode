class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int res = 0;
        vector<int> row(m, 0);
        for (int i = 0; i < (1 << n); ++i) {
            if (__builtin_popcount(i) != numSelect) continue;
            for (int j = 0; j < m; ++j) row[j] = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    for (int k = 0; k < m; ++k) {
                        row[k] += matrix[k][j];
                    }
                }
            }
            int cnt = 0;
            for (int j = 0; j < m; ++j) {
                if (row[j] == 0) cnt++;
            }
            res = max(res, cnt);
        }
        return res;
    }
};