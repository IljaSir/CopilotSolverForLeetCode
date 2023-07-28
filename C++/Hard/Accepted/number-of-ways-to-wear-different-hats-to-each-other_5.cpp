class Solution {
public:
    int numberWays(vector<vector<int>>& hats) {
        
        const int MOD = 1000000007;
        int n = hats.size();
        vector<vector<int>> dp(1 << n, vector<int>(41, 0));
        vector<vector<int>> person(41);
        for (int i = 0; i < n; i++) {
            for (int hat : hats[i]) {
                person[hat].push_back(i);
            }
        }
        dp[0][0] = 1;
        for (int i = 1; i <= 40; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[j][i] = dp[j][i - 1];
                for (int k : person[i]) {
                    if (j & (1 << k)) {
                        dp[j][i] = (dp[j][i] + dp[j ^ (1 << k)][i - 1]) % MOD;
                    }
                }
            }
        }
        return dp[(1 << n) - 1][40];
    }
};