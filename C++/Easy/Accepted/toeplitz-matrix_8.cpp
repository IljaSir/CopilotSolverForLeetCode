class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int i = 0;
        int j = 0;
        int val = matrix[0][0];
        while (i < m - 1 && j < n - 1) {
            if (val != matrix[i + 1][j + 1]) {
                return false;
            }
            if (j == n - 2) {
                i++;
                j = 0;
                val = matrix[i][j];
            } else {
                j++;
                val = matrix[i][j];
            }
        }
        return true;
    }
};