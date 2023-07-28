class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        int n = types.size();
        int m = target;
        int mod = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        // dp[i][j] = number of ways to reach j with first i types of questions
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= types[i - 1][0]; k++) {
                    if (j - k * types[i - 1][1] >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k * types[i - 1][1]]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[n][m];
    }
};