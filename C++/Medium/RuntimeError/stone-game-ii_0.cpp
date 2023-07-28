class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        
        int n = piles.size();
        vector<int> sum(n + 1, 0);
        for (int i = n - 1; i >= 0; --i) {
            sum[i] = sum[i + 1] + piles[i];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = sum[i];
        }
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i + l - 1 < n; ++i) {
                int j = i + l - 1;
                for (int x = 1; x <= 2 * (j - i + 1); ++x) {
                    dp[i][j] = max(dp[i][j], sum[i] - dp[i + x][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
};