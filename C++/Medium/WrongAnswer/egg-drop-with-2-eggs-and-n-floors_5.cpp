class Solution {
public:
    int twoEggDrop(int n) {
        
        int dp[2][n + 1];
        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= n; ++i) {
            dp[0][i] = 1;
            dp[1][i] = i;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int minn = 0x3f3f3f3f;
                for (int k = 1; k <= j; ++k) {
                    minn = min(minn, 1 + max(dp[0][k - 1], dp[1][j - k]));
                }
                dp[0][j] = dp[1][j];
                dp[1][j] = minn;
            }
        }
        return dp[1][n];
    }
};