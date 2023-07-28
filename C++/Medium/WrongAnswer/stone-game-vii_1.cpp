class Solution {
public:
    int stoneGameVII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> sums(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + stones[i - 1];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = max(sums[j + 1] - sums[i + 1] - dp[i + 1][j], sums[j] - sums[i] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
};