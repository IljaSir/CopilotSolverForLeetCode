class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int m = pizza.size(), n = pizza[0].size();
        vector<vector<int>> sum(m+1, vector<int>(n+1));
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (pizza[i-1][j-1] == 'A');
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k+1, -1)));
        return dfs(pizza, sum, dp, 0, 0, k);
    }
    int dfs(vector<string>& pizza, vector<vector<int>>& sum, vector<vector<vector<int>>>& dp, int i, int j, int k) {
        int m = pizza.size(), n = pizza[0].size(), mod = 1e9+7;
        if(sum[m][n] - sum[i][n] - sum[m][j] + sum[i][j] == 0) return 0;
        if(k == 1) return 1;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        int res = 0;
        for(int p = i; p < m-1; p++) 
            if(sum[p+1][n] - sum[i][n] - sum[p+1][j] + sum[i][j] > 0)
                res = (res + dfs(pizza, sum, dp, p+1, j, k-1)) % mod;
        for(int p = j; p < n-1; p++) 
            if(sum[m][p+1] - sum[i][p+1] - sum[m][j] + sum[i][j] > 0)
                res = (res + dfs(pizza, sum, dp, i, p+1, k-1)) % mod;
        return dp[i][j][k] = res;
    }
};