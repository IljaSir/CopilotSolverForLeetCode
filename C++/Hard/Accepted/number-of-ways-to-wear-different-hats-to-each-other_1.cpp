class Solution {
public:
    int numberWays(vector<vector<int>>& hats) {
        
        int n = hats.size(), mod = 1e9 + 7;
        vector<vector<int>> people(40);
        for (int i = 0; i < n; ++i) {
            for (int hat : hats[i]) {
                people[hat - 1].push_back(i);
            }
        }
        vector<vector<int>> dp(1 << n, vector<int>(41));
        dp[0][0] = 1;
        for (int i = 0; i < 40; ++i) {
            for (int mask = (1 << n) - 1; mask >= 0; --mask) {
                for (int j = 0; j <= n; ++j) {
                    if (dp[mask][j] == 0) {
                        continue;
                    }
                    dp[mask][j + 1] = (dp[mask][j + 1] + dp[mask][j]) % mod;
                    for (int p : people[i]) {
                        if (mask & (1 << p)) {
                            continue;
                        }
                        dp[mask | (1 << p)][j + 1] = (dp[mask | (1 << p)][j + 1] + dp[mask][j]) % mod;
                    }
                }
            }
        }
        return dp[(1 << n) - 1][n];
    }
};