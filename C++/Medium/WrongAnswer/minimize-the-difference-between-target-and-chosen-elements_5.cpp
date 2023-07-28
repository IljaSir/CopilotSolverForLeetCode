class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int m = mat.size(), n = mat[0].size();
        vector<int> dp(800, 0);
        for (int i = 0; i < m; ++i) {
            vector<int> tmp(800, 0);
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 800; ++k) {
                    if (dp[k] == 0) continue;
                    tmp[k + mat[i][j]] = 1;
                }
            }
            for (int j = 0; j < 800; ++j) {
                if (tmp[j] == 1) dp[j] = 1;
            }
        }
        int res = INT_MAX;
        for (int i = 0; i < 800; ++i) {
            if (dp[i] == 1) res = min(res, abs(i - target));
        }
        return res;
    }
};