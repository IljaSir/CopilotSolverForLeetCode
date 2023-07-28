class Solution {
public:
    int twoEggDrop(int n) {
        
        int dp[n + 1][3];
        for (int i = 0; i <= n; i++) {
            dp[i][1] = i;
            dp[i][2] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= 2; j++) {
                dp[i][j] = INT_MAX;
                for (int x = 1; x <= i; x++) {
                    int res = 1 + max(dp[x - 1][j - 1], dp[i - x][j]);
                    dp[i][j] = min(dp[i][j], res);
                }
            }
        }
        return dp[n][2];
    }
};