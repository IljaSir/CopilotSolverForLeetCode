class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        vector<vector<int>> dp(n, vector<int>(n));
        vector<vector<int>> paren(n, vector<int>(n));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = expression[i] - '0';
        }
        for (int i = 0; i < n; i += 2) {
            for (int j = i - 2; j >= 0; j -= 2) {
                dp[j][i] = dp[j][j] + dp[j + 2][i];
                paren[j][i] = j + 1;
                for (int k = j + 3; k <= i; k += 2) {
                    int v = dp[j][k - 2] + dp[k][i];
                    if (v < dp[j][i]) {
                        dp[j][i] = v;
                        paren[j][i] = k;
                    }
                }
            }
        }
        return build(expression, 0, n - 1, paren);
    }
};