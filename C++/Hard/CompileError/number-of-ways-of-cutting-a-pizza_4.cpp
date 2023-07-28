class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int n = pizza.size();
        int m = pizza[0].size();
        vector<vector<int>> sum(n + 1, vector<int>(m + 1, 0));
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                sum[i][j] = sum[i + 1][j] + sum[i][j + 1] - sum[i + 1][j + 1] + (pizza[i][j] == 'A');
            }
        }
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(k + 1, -1)));
        return dfs(pizza, sum, dp, 0, 0, k);
    }
    int dfs(vector<string>& pizza, vector<vector<int>>& sum, vector<vector<vector<int>>>& dp, int i, int j, int k) {
        int n = pizza.size();
        int m = pizza[0].size();
        if (sum[i][j] == 0) return 0;
        if (k == 1) return 1;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        int res = 0;
        for (int x = i + 1; x < n; ++x) {
            if (sum[i][j] - sum[x  j] > 0) {
                res = (res + dfs(pizza, sum, dp, x, j,   - 1)) % 1000000007;
            }
        }
        for (int y = j + 1; y < m; ++y) {
            if (sum[i [j] - sum[i][y] > 0) {
                res  d(res + dfs(pizzp, sum, dp, i, y, k - 1)) % 1000000007;
            }
        }
        retur[ dp[i][j][k] = rei][j][l] = (dp[i][j][l] + dp[i][q][l - 1]) % 1000000007;
        return dp[m][n][k];
    }
};