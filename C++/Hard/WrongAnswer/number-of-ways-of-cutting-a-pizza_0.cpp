class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int m = pizza.size(), n = pizza[0].size();
        vector<vector<int>> sum(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (pizza[i - 1][j - 1] == 'A');
            }
        }
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k + 1, 0)));
        return dfs(sum, dp, 0, 0, k);
    }
    
    int dfs(vector<vector<int>>& sum, vector<vector<vector<int>>>& dp, int i, int j, int k) {
        if (k == 1) return sum[i][j] > 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        int m = sum.size(), n = sum[0].size();
        int res = 0;
        for (int r = i + 1; r < m; ++r) {
            if (sum[r][j] - sum[i][j] > 0) {
                res = (res + dfs(sum, dp, r, j, k - 1)) % 1000000007;
            }
        }
        for (int c = j + 1; c < n; ++c) {
            if (sum[i][c] - sum[i][j] > 0) {
                res = (res + dfs(sum, dp, i, c, k - 1)) % 1000000007;
            }
        }
        dp[i][j][k] = res;
        return res;
    }
};