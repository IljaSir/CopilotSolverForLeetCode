class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size(), n = mat[0].size();
        vector<int> dp(n, 0);
        for (int i = 0; i < m; ++i) {
            vector<int> tmp(n * m, INT_MAX);
            for (int j = 0; j < n; ++j) {
                for (int l = 0; l < n; ++l) {
                    tmp[j * n + l] = min(tmp[j * n + l], dp[l] + mat[i][j]);
                }
            }
            sort(tmp.begin(), tmp.end());
            dp.assign(tmp.begin(), tmp.begin() + n);
        }
        return dp[k - 1];
    }
};