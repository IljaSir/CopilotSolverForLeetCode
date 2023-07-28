class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> res;
        int i = 0, j = 0;
        int x = 0, y = 0;
        int dir = 0;
        while (res.size() < m * n) {
            res.push_back(matrix[i][j]);
            matrix[i][j] = 0;
            if (dir == 0) {
                if (j + 1 < n && matrix[i][j + 1] != 0) {
                    j++;
                } else {
                    dir = 1;
                    i++;
                }
            } else if (dir == 1) {
                if (i + 1 < m && matrix[i + 1][j] != 0) {
                    i++;
                } else {
                    dir = 2;
                    j--;
                }
            } else if (dir == 2) {
                if (j - 1 >= 0 && matrix[i][j - 1] != 0) {
                    j--;
                } else {
                    dir = 3;
                    i--;
                }
            } else {
                if (i - 1 >= 0 && matrix[i - 1][j] != 0) {
                    i--;
                } else {
                    dir = 0;
                    j++;
                }
            }
        }
        return res;
    }
};