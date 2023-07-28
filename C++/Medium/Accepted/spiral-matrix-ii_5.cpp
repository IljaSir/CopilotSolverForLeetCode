class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> result(n, vector<int>(n));
        int num = 1;
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = num++;
            }
            rowBegin++;
            // Traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = num++;
            }
            colEnd--;
            // Traverse Left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result[rowEnd][i] = num++;
                }
            }
            rowEnd--;
            // Traverse Up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[i][colBegin] = num++;
                }
            }
            colBegin++;
        }
        return result;
    }
};