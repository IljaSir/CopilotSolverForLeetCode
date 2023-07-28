class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        vector<int> result;
        int m = mat.size(), n = mat[0].size();
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i++) {
            result.push_back(mat[r][c]);
            if ((r + c) % 2 == 0) { // moving up
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else { // moving down
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
};