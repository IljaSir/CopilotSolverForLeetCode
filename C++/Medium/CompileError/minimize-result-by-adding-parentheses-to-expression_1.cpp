class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = expression[i] - '0';
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i += 2) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k += 2) {
                    int left = dp[i][k - 1], right = dp[k + 1][j];
                    if (expression[k] == '+') {
                        dp[i][j] = min(dp[i][j], left + right);
                    } else {
                        dp[i][j] = min(dp[i][j], left * right);
                    }
                }
            }
        }
        return dfs(expression, 0, n - 1, dp);
    }
};