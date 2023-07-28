class Solution {
public:
    int numberWays(vector<vector<int>>& hats) {
        
        int n = hats.size();
        int m = 40;
        int mod = 1e9 + 7;
        vector<vector<int>> dp(1 << n, vector<int>(m + 1, 0));
        dp[0][0] = 1;
        vector<vector<int>> people(m + 1, vector<int>());
        for (int i = 0; i < n; ++i) {
            for (int hat : hats[i]) {
                people[hat].push_back(i);
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < (1 << n); ++j) {
                dp[j][i] = dp[j][i - 1];
                for (int p : people[i]) {
                    if ((j & (1 << p)) == 0) {
                        dp[j | (1 << p)][i] = (dp[j | (1 << p)][i] + dp[j][i - 1]) % mod;
                    }
                }
            }
        }
        return dp[(1 << n) - 1][m];
    }
};