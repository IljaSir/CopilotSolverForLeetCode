class Solution {
public:
    int numberWays(vector<vector<int>>& hats) {
        
        const int MOD = 1000000007;
        int n = hats.size();
        vector<vector<int>> people(41);
        for (int i = 0; i < n; i++) {
            for (auto h : hats[i]) {
                people[h].push_back(i);
            }
        }
        
        vector<vector<int>> dp(n, vector<int>(1 << n));
        dp[0][1 << 0] = 1;
        for (int i = 1; i < 41; i++) {
            for (auto p : people[i]) {
                for (int j = 0; j < (1 << n); j++) {
                    if (j & (1 << p)) {
                        dp[p][j] = (dp[p][j] + dp[p][j ^ (1 << p)]) % MOD;
                    }
                    else {
                        dp[p][j] = (dp[p][j] + dp[p - 1][j]) % MOD;
                    }
                }
            }
        }
        return dp[n - 1][(1 << n) - 1];
    }
};