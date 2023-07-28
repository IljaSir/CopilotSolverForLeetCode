class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> ans;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                for (int j = min(i, m - 1); j >= max(0, i - n + 1); j--) {
                    ans.push_back(mat[j][i - j]);
                }
            } else {
                for (int j = max(0, i - n + 1); j <= min(i, m - 1); j++) {
                    ans.push_back(mat[j][i - j]);
                }
            }
        }
        return ans;
    }
};