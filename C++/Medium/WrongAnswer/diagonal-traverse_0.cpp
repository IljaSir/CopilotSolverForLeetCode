class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> res;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                int j = max(0, i - n + 1);
                while (j <= i && j < m) {
                    res.push_back(mat[j][i - j]);
                    j++;
                }
            } else {
                int j = min(i, m - 1);
                while (j >= 0 && j > i - n) {
                    res.push_back(mat[j][i - j]);
                    j--;
                }
            }
        }
        return res;
    }
};