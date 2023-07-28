class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int sum = accumulate(stones.begin(), stones.end(), 0);
        int n = stones.size();
        int m = sum / 2;
        vector<vector<int>> dp(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * dp[n][m];
    }
};