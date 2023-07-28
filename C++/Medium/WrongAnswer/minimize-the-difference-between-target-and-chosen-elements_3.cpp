class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> dp(800, 0);
        for (int i = 0; i < m; ++i) {
            vector<int> tmp(800, 0);
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 800; ++k) {
                    if (dp[k] && k + mat[i][j] < 800) {
                        tmp[k + mat[i][j]] = 1;
                    }
                }
            }
            for (int j = 0; j < 800; ++j) {
                if (tmp[j]) {
                    dp[j] = 1;
                }
            }
            dp[mat[i][0]] = 1;
        }
        int ans = INT_MAX;
        for (int i = 0; i < 800; ++i) {
            if (dp[i]) {
                ans = min(ans, abs(i - target));
            }
        }
        return ans;
    }
};