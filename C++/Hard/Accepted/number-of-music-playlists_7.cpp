class Solution {
public:
    int numMusicPlaylists(int n, int goal, int k) {
        
        long long dp[101][101] = {0};
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) + dp[i - 1][j] * max(j - k, 0);
                dp[i][j] %= 1000000007;
            }
        }
        return dp[goal][n];
    }
};