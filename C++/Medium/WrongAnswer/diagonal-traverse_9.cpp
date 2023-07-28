class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        vector<int> res;
        int row = mat.size(), col = mat[0].size();
        for (int i = 0; i < row + col - 1; i++) {
            int r = i < col ? 0 : i - col + 1;
            int c = i < col ? i : col - 1;
            while (r < row && c > -1) {
                res.push_back(mat[r++][c--]);
            }
            if (i % 2) {
                reverse(res.end() - min(row, col), res.end());
            }
        }
        return res;
    }
};