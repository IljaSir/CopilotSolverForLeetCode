class Solution {
public:
    int numMusicPlaylists(int n, int goal, int k) {
        
        vector<vector<long long>> dp(goal+1, vector<long long>(n+1));
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j-1] * (n - j + 1)) % 1000000007;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j] * (j - k)) % 1000000007;
                }
            }
        }
        return dp[goal][n];
    }
};