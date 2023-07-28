class Solution {
public:
    int minOperationsToFlip(string expression) {
        
        int n = expression.size();
        vector<vector<int>> f(n, vector<int>(n));
        vector<vector<int>> g(n, vector<int>(n));
        for (int i = 0; i < n; i++) {
            if (expression[i] == '1') {
                f[i][i] = 0;
                g[i][i] = 1;
            }
            else if (expression[i] == '0') {
                f[i][i] = 1;
                g[i][i] = 0;
            }
        }
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                f[i][j] = INT_MAX;
                g[i][j] = INT_MIN;
                for (int k = i; k < j; k += 2) {
                    if (expression[k + 1] == '&') {
                        f[i][j] = min(f[i][j], f[i][k] + f[k + 2][j]);
                        g[i][j] = max(g[i][j], g[i][k] + g[k + 2][j]);
                    }
                    else if (expression[k + 1] == '|') {
                        f[i][j] = min(f[i][j], f[i][k] + f[k + 2][j]);
                        g[i][j] = max(g[i][j], g[i][k] + g[k + 2][j]);
                        f[i][j] = min(f[i][j], f[i][k] + g[k + 2][j] + 1);
                        g[i][j] = max(g[i][j], g[i][k] + f[k + 2][j] + 1);
                    }
                }
            }
        }
        return f[0][n - 1];
    }
};