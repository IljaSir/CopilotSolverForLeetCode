class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int minW = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        minW = min(minW, dp[k][j]);
                        res += minW;
                    }
                }
            }
        }
        return res;
    }
};