class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        bool row0 = false;
        bool col0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        for (f (cols[j] == 0) {
                ior (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
};