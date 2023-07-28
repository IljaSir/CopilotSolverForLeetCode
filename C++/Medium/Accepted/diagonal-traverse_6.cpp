class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        vector<int> ans;
        int i = 0, j = 0;
        bool up = true;
        while (i < m && j < n) {
            ans.push_back(mat[i][j]);
            if (up) {
                if (j == n - 1) {
                    i++;
                    up = !up;
                } else if (i == 0) {
                    j++;
                    up = !up;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                    up = !up;
                } else if (j == 0) {
                    i++;
                    up = !up;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }
};