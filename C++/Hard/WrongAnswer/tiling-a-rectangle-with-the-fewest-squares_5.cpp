class Solution {
public:
    int tilingRectangle(int n, int m) {
        
        int dp[14][14] = {};
        for (int i = 1; i <= 13; i++) {
            for (int j = i + 1; j <= 13; j++) {
                dp[i][j] = dp[j][i] = dp[i][j - i] + dp[i][i];
            }
        }
        return dp[n][m];
    }
};