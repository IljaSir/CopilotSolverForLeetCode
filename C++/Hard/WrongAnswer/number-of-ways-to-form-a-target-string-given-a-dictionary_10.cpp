class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words[0].size();
        int m = target.size();
        int mod = 1e9+7;
        vector<vector<long long>> dp(m, vector<long long>(n, 0));
        for (int j = 0; j < n; ++j) {
            if (words[0][j] == target[0]) dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (words[0][j] == target[i]) dp[i][j] = dp[i-1][j];
                for (int k = 0; k < j; ++k) {
                    if (words[0][k] == target[i-1]) dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
                }
            }
        }
        long long ans = 0;
        for (int j = 0; j < n; ++j) {
            ans = (ans + dp[m-1][j]) % mod;
        }
        return ans;
    }
};