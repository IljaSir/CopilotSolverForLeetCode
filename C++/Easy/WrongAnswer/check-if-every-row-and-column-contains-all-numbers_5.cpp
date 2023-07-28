class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val <= 0 || val > n) return false;
                matrix[i][j] = -val;
                if (matrix[val-1][j] > 0) return false;
                matrix[val-1][j] = -val;
                if (matrix[i][val-1] > 0) return false;
                matrix[i][val-1] = -val;
            }
        }
        return true;
    }
};