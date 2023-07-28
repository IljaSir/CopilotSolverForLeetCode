class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        vector<int> row(m, 0);
        vector<int> col(n, 0);
        for (auto& index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int oddRow = 0;
        int oddCol = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] & 1) {
                oddRow++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (col[i] & 1) {
                oddCol++;
            }
        }
        return oddRow * n + oddCol * m - 2 * oddRow * oddCol;
    }
};