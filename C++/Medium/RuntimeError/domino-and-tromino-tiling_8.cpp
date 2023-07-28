class Solution {
public:
    int numTilings(int n) {
        
        const int MOD = 1e9 + 7;
        
        // f[i][j] = number of ways to tile a 2 x i board with j dominoes
        // f[i][j] = f[i-1][j] + f[i-2][j] + f[i-1][j-1] + f[i-2][j-1] + f[i-2][j-2]
        // f[i][j] = f[i-1][j] + f[i-2][j] + f[i-1][j-1] + f[i-2][j-1] + f[i-2][j-2]
        
        vector<vector<int>> f(n + 1, vector<int>(n + 1, 0));
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i][0] = f[i - 1][0];
            if (i >= 2) f[i][0] = (f[i][0] + f[i - 2][0]) % MOD;
            for (int j = 1; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (i >= 2) f[i][j] = (f[i][j] + f[i - 2][j]) % MOD;
                f[i][j] = (f[i][j] + f[i - 1][j - 1]) % MOD;
                if (i >= 2) f[i][j] = (f[i][j] + f[i - 2][j - 1]) % MOD;
                if (j >= 2) f[i][j] = (f[i][j] + f[i - 2][j - 2]) % MOD;
            }
        }
        
        return f[n][n];
    }
};