class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = max(ans, stones[i] - stones[i - 1]);
        }
        return ans;
    }
    int minCost(vector<int>& stones) {
        int n = stones.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[0][i] = stones[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] + stones[j] - stones[j - 1]);
            }
        }
        return dp[n - 1][n - 1];
    }
    int frogJump(vector<int>& stones) {
        int n = stones.size();
        int maxJump = maxJump(stones);
        vector<vector<int>> dp(n, vector<int>(maxJump + 1, 0));
        dp[0][0] = stones[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxJump; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + stones[i] - stones[i - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + stones[i] - stones[i - 1], dp[i - 1][j] + stones[i] - stones[i - 1]);
                }
            }
        }
        return dp[n - 1][0];
    }
};