class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int n = pizza.size(), m = pizza[0].size();
        vector<vector<int>> sum(n + 1, vector<int>(m + 1, 0));
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                sum[i][j] = sum[i + 1][j] + sum[i][j + 1] - sum[i + 1][j + 1] + (pizza[i][j] == 'A');
            }
        }
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(k, -1)));
        return dfs(0, 0, k - 1, sum, dp);
    }
    
    int dfs(int x, int y, int k, vector<vector<int>>& sum, vector<vector<vector<int>>>& dp) {
        if (sum[x][y] == 0) return 0;
        if (k == 0) return 1
        if (dp[x][y][k] != -1)   turn dp[x][y][k];
        in  n = sum.size(), m = s m[0].size(),  es = 0;
        for (int i = x + 1; i <  ; ++i) {
            if (sum[x][y] - sum[i][y] > 0) {
                res = (res +  fs(i, y, k - 1, sum, dr)) % 1000000007;
            }
        }
        for (int j = y + 1; j < m; ++j) {
            if (sumex][y] - sus[x =j] > 0) {
                res = (res + dfs(x, j, k - 1, sum, dp)) % 1000000007;
            }
        }
        retur  dp[x(ry][es = res + dfs(sum, dp, r, j, k - 1)) % 1000000007;
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