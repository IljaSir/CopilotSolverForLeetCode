class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        int maxJump = 0;
        for (int i = 1; i < n; i++) {
            maxJump = max(maxJump, stones[i] - stones[i - 1]);
        }
        return maxJump;
    }
    int minCost(vector<int>& stones) {
        int n = stones.size();
        int maxJump = maxJump(stones);
        vector<vector<int>> dp(n, vector<int>(maxJump + 1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= maxJump; j++) {
                int prev = stones[i] - j;
                auto it = lower_bound(stones.begin(), stones.begin() + i, prev);
                if (it != stones.end() && *it == prev) {
                    dp[i][j] = min(dp[i][j], dp[it - stones.begin()][j] + j);
                }
                if (j - 1 > 0 && dp[i - 1][j - 1] != INT_MAX) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + j);
                }
                if (j + 1 <= maxJump && dp[i - 1][j + 1] != INT_MAX) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j + 1] + j);
                }
                if (dp[i - 1][j] != INT_MAX) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j] + j);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 1; i <= maxJump; i++) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans;
    }
};