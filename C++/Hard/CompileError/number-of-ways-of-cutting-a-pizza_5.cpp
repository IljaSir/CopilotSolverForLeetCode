class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int mod = 1e9 + 7;
        int m = pizza.size(), n = pizza[0].size();
        vector<vector<int>> sum(m + 1, vector<int>(n + 1, 0));
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                sum[i][j] = sum[i + 1][j] + sum[i][j + 1] - sum[i + 1][j + 1] + (pizza[i][j] == 'A');
            }
        }
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k, -1)));
        return dfs(pizza, sum, dp, 0, 0, k - 1, mod);
    }
    int dfs(vector<string>& pizza, vector<vector<int>>& sum, vector<vector<vector<int>>>& dp, int x, int y, int k, int mod) {
        if (dp[x][y][k] != -1) return dp[x][y][k];
        if (k == 0) return dp[x][y][k] = (sum[x][y] > 0);
        int m = pizza.size(), n = pizza[0].size();
        int ans = 0;
        for (int i = x + 1; i < m; ++i) {
            if (sum[x][y] - sum[i][y] > 0) {
                ans = (ans + dfs(pizza, sum, dp, i, y, k - 1, mod)) % mod;
            }
        }
        for (int j = y + 1; j < n; ++j) {
            if (sum[x][y] - sum[x][j] > 0) {
                ans = (ans + dfs(pizza, sum, dp, x, j, k - 1, mod)) % mod;
            }
        }-1] = res;
    }
};