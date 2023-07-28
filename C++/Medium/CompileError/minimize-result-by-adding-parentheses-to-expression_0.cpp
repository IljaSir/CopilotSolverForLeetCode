class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = expression[i] - '0';
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k += 2) {
                    int left = dp[i][k - 1];
                    int right = dp[k + 1][j];
                    int val = 0;
                    if (expression[k] == '+') {
                        val = left + right;
                    } else {
                        val = left * right;
                    }
                    if (val < dp[i][j]) {
                        dp[i][j] = val;
                    }
                }
            }
        }
        return dfs(expression, dp, 0, n - 1);
    }
};