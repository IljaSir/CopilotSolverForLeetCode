class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        for (int i = 0; i < m; i++) {
            int x = i, y = 0;
            int v = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != v) return false;
                x++;
                y++;
            }
        }
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            int v = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != v) return false;
                x++;
                y++;
            }
        }
        return true;
    }
};