class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                }
                int width = INT_MAX;
                for (int k = i; k >= 0; k--) {
                    width = min(width, dp[k][j]);
                    ans += width;
                }
            }
        }
        return ans;
    }
};