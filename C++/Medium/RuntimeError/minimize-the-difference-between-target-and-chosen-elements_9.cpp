class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int n = mat.size();
        int m = mat[0].size();
        int dp[80][8000];
        memset(dp, 0x3f, sizeof(dp));
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k <= 8000; k++) {
                    dp[i + 1][k] = min(dp[i + 1][k], dp[i][k]);
                    dp[i + 1][k + mat[i][j]] = min(dp[i + 1][k + mat[i][j]], dp[i][k]);
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int i = 0; i <= 8000; i++) {
            if (dp[n][i] != 0x3f3f3f3f) {
                ans = min(ans, abs(target - i));
            }
        }
        return ans;
    }
};