class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                dp[i][j] = j > 0 ? dp[i][j - 1] + 1 : 1;
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = min(width, dp[k][j]);
                    res += width;
                }
            }
        }
        return res;
    }
};