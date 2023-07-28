class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        vector<int> result;
        int m = mat.size();
        int n = mat[0].size();
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < m * n) {
            result.push_back(mat[i][j]);
            if ((i + j) % 2 == 0) {
                if (j == n - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
            k++;
        }
        return result;
    }
};