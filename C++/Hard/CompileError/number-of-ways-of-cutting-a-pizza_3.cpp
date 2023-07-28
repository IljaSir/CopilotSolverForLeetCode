class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int m = pizza.size(), n = pizza[0].size();
        vector<vector<int>> sum(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (pizza[i - 1][j - 1] == 'A');
        vector<vector<vector<int>>> dp(m + 1, vector<vector<int>>(n + 1, vector<int>(k + 1, 0)));
        for (int i = 0; i <= m; ++i)
            for (int j = 0; j <= n; ++j)
                dp[i][j][0] = 1;
        for (int l = 1; l <= k; ++l)
            for (int i = 1; i <= m; ++i)
                for (int j = 1; j <= n; ++j)
                    for (int p = 1; p < i; ++p)
                        if (sum[i][j] - sum[p][j] > 0)
                            dp[i][j][l] = (dp[i][j][l] + dp[p][j][l - 1]) % 1000000007;
                    for (int q = 1; q < j; ++q)
                        if (sum[i][j] - sum[i][q] > 0)
                      ][k] = ans;
    }
};