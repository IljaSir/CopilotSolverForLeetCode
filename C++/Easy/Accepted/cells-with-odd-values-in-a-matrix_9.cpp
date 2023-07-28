class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        
        vector<vector<int>> matrix(m, vector<int>(n, 0));
        for (auto &row: matrix) {
            for (auto &cell: row) {
                cell = 0;
            }
        }
        for (auto &index: indices) {
            for (int i = 0; i < n; i++) {
                matrix[index[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;
            }
        }
        int oddCount = 0;
        for (auto &row: matrix) {
            for (auto &cell: row) {
                if (cell % 2 == 1) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }
};