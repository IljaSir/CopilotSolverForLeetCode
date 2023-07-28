class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> dp(nvector<int>(1, 0
            for (int j = 0; j < 10; j++) {
                for (auto& d : dir) {
                    int x = j / 3 + d[0];
                    int y = j % 3 + d[1];
                    if (x >= 0 && x < 3 && y >= 0 && y < 3 && (x * 3 + y) != 9 && (x * 3 + y) != 11) {
                        dp[i][j] += dp[i - 1][x * 3 + y];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n - 1][i];
            ans %= 1000000007;
        }
        return res;
    }
};