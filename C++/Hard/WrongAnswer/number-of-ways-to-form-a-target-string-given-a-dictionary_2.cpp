class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words.size();
        int m = words[0].size();
        int t = target.size();
        vector<vector<int>> count(m, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                count[j][words[i][j] - 'a']++;
            }
        }
        int mod = 1e9 + 7;
        vector<vector<long long>> dp(t, vector<long long>(m, 0));
        for (int j = 0; j < m; ++j) {
            if (count[j][target[0] - 'a'] > 0) {
                dp[0][j] = count[j][target[0] - 'a'];
            }
        }
        for (int i = 1; i < t; ++i) {
            for (int j = i; j < m; ++j) {
                dp[i][j] = dp[i][j - 1];
                if (count[j][target[i] - 'a'] > 0) {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k] * count[j][target[i] - 'a'];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        long long ans = 0;
        for (int j = t - 1; j < m; ++j) {
            ans += dp[t - 1][j];
            ans %= mod;
        }
        return ans;
    }
};