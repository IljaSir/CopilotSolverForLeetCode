class Solution {
public:
    int stoneGameVII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> sums(stones);
        for (int i = 1; i < n; ++i) {
            sums[i] += sums[i - 1];
        }
        vector<vector<int>> dp(n, vector<int>(n));
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = max(sums[j] - sums[i] - dp[i + 1][j], sums[j - 1] - (i > 0 ? sums[i - 1] : 0) - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
};