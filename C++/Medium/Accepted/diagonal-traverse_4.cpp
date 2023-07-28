class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> res(m * n);
        int i = 0;
        int j = 0;
        int k = 0;
        int dir = 1;
        while (k < m * n) {
            res[k++] = mat[i][j];
            if (dir == 1) {
                if (j == n - 1) {
                    i++;
                    dir = -1;
                } else if (i == 0) {
                    j++;
                    dir = -1;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                    dir = 1;
                } else if (j == 0) {
                    i++;
                    dir = 1;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
};