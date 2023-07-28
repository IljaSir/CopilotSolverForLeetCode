class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);
        for (auto& r : indices) {
            ++rows[r[0]];
            ++cols[r[1]];
        }
        int oddRows = 0;
        for (int i = 0; i < m; ++i) {
            if (rows[i] % 2 == 1) {
                ++oddRows;
            }
        }
        int oddCols = 0;
        for (int i = 0; i < n; ++i) {
            if (cols[i] % 2 == 1) {
                ++oddCols;
            }
        }
        return oddRows * n + oddCols * m - oddRows * oddCols * 2;
    }
};