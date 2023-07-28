class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        for (int i = 0; i < m; ++i) {
            int x = i;
            int y = 0;
            int tmp = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != tmp) {
                    return false;
                }
                ++x;
                ++y;
            }
        }
        for (int i = 1; i < n; ++i) {
            int x = 0;
            int y = i;
            int tmp = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != tmp) {
                    return false;
                }
                ++x;
                ++y;
            }
        }
        return true;
    }
};