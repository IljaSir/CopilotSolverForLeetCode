class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        for (int i = 0; i < m; i++) {
            int x = i;
            int y = 0;
            while (x < m && y < n) {
                if (matrix[i][0] != matrix[x][y]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int j = 1; j < n; j++) {
            int x = 0;
            int y = j;
            while (x < m && y < n) {
                if (matrix[0][j] != matrix[x][y]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
};