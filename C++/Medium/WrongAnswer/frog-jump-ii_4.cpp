class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        int m = 0;
        for (int i = 1; i < n; ++i) {
            m = max(m, stones[i] - stones[i - 1]);
        }
        return m;
    }
    int minCost(vector<int>& stones) {
        int n = stones.size();
        int m = maxJump(stones);
        vector<vector<int>> dp(n, vector<int>(m + 1, INT_MAX));
        dp[0][1] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (dp[i - 1][j] == INT_MAX) continue;
                int k = stones[i] - stones[i - 1];
                if (k > j) {
                    dp[i][k] = min(dp[i][k], dp[i - 1][j]);
                } else {
                    dp[i][k] = min(dp[i][k], dp[i - 1][j]);
                    dp[i][j] = min(dp[i][j], dp[i - 1][j] + (j - k));
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 1; i <= m; ++i) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans;
    }
};