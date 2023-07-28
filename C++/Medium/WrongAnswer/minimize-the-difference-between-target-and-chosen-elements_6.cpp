class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int m = mat.size(), n = mat[0].size();
        vector<int> dp(800, 0);
        for (int i = 0; i < m; i++) {
            vector<int> tmp(800, 0);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 750; k++) {
                    if (dp[k] > 0) {
                        tmp[k + mat[i][j]] = 1;
                    }
                }
            }
            for (int j = 0; j <= 750; j++) {
                if (tmp[j] > 0) {
                    dp[j] = 1;
                }
            }
        }
        int ans = 800;
        for (int i = 0; i <= 750; i++) {
            if (dp[i] > 0) {
                ans = min(ans, abs(i - target));
            }
        }
        return ans;
    }
};