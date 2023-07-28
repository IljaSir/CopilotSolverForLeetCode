class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) continue;
                dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;
                int minlen = dp[i][j];
                for (int k = i; k >= 0; --k) {
                    minlen = min(minlen, dp[k][j]);
                    ret += minlen;
                }
            }
        }
        return ret;
    }
};