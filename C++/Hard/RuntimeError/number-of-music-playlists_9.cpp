class Solution {
public:
    int numMusicPlaylists(int n, int goal, int k) {
        
        vector<vector<int>> dp(n+1, vector<int>(goal+1,0));
        dp[0][0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=i; j<=goal; j++) {
                dp[i][j] = (dp[i-1][j-1] * (n-i+1) + dp[i][j-1] * max(i-k,0)) % 1000000007;
            }
        }
        return dp[n][goal];
    }
};