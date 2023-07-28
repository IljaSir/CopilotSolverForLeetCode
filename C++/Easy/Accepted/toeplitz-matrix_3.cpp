class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        for (int i = 0; i < m; ++i) {
            int x = i;
            int y = 0;
            int val = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != val) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int j = 1; j < n; ++j) {
            int x = 0;
            int y = j;
            int val = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != val) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
};