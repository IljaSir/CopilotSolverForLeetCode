class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> res;
        for (int i = 0; i < m + n - 1; i++) {
            int start = max(0, i - n + 1);
            int count = min(i, m - 1) - start + 1;
            if (i % 2 == 0) {
                for (int j = 0; j < count; j++) {
                    res.push_back(mat[start + j][i - start - j]);
                }
            } else {
                for (int j = count - 1; j >= 0; j--) {
                    res.push_back(mat[start + j][i - start - j]);
                }
            }
        }
        return res;
    }
};