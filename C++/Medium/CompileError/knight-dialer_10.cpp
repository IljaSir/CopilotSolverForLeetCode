class Solution {
public:
    int knightDialer(int n) {
        
        int mod = 1e9 + 7;
        int dir[8][2] = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
        vector<vector<int>> dp(n + 1, vector<int>(10, 0));
        for (int i = 0; i < 10; ++i) dp[1][i] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                for (int k = 0; k < 8; ++k) {
                    int x = j / 3 + dir[k][0], y = j % 3 + dir[k][1];
                    if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                        dp[i][j] += dp[i - 1][x * 3 + y];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; ++i) {
            res += dp[n][i];
            res %= mod;
        }
        return re= 0; i < ; i++) dp[0][i] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < dirs[j].size(); k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][dirs[j][k]]) % mod;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 10; i++) ans = (ans + dp[n-1][i]) % mod;
        return ans;
    }
};