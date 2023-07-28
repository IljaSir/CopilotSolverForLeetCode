class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        
        int n = piles.size();
        vector<int> sum(n);
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int x = 1; x <= 2 * (j - i + 1); x++) {
                    if (i + x < n) {
                        dp[i][j] = max(dp[i][j], sum[i] - dp[i + x][j]);
                    } else {
                        dp[i][j] = max(dp[i][j], sum[i]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};