class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int m = pizza.size(), n = pizza[0].size();
        vector<vector<int>> sum(m+1, vector<int>(n+1, 0));
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sum[i][j] = sum[i+1][j] + sum[i][j+1] - sum[i+1][j+1] + (pizza[i][j] == 'A');
            }
        }
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k, -1)));
        return dfs(pizza, sum, dp, 0, 0, k);
    }
    int dfs(vector<string>& pizza, vector<vector<int>>& sum, vector<vector<vector<int>>>& dp, int i, int j, int k) {
        if (sum[i][j] == 0) return 0;
        if (k == 1) return 1;
        if (dp[i][j][k-1] != -1) return dp[i][j][k-1];
        int m = pizza.size(), n = pizza[0].size();
        int res = 0;
        for (int r = i + 1; r < m; r++) {
            if (sum[r][j] > 0 && sum[i][j] - sum[r][j] > 0) {
                res = (res + dfs(pizza, sum, dp, r, j, k - 1)) % 1000000007;
            }
        }
        for (int c = j + 1; c < n; c++) {
            if (sum[i][c] > 0 && sum[i][j] - sum[i][c] > 0) {
                res = (res + dfs(pizza, sum, dp, i, c, k - 1)) % 1000000007;
            }
        }
        return dp[i][j][k-1] = res;
    }
};