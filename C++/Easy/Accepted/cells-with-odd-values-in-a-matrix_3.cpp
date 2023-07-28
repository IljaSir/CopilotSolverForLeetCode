class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);
        for (auto& v : indices) {
            rows[v[0]]++;
            cols[v[1]]++;
        }
        
        int oddRows = 0;
        int oddCols = 0;
        for (int i = 0; i < m; i++) {
            if (rows[i] % 2 != 0) {
                oddRows++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (cols[i] % 2 != 0) {
                oddCols++;
            }
        }
        
        return oddRows * n + oddCols * m - 2 * oddRows * oddCols;
    }
};