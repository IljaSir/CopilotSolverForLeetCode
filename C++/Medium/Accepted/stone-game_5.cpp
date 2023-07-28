class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        
        int n = piles.size();
        // dp[i][j] represents the max number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
};