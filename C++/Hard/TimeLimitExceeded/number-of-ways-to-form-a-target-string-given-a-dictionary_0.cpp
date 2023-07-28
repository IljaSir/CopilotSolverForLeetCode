class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words.size(), m = words[0].size(), t = target.size();
        vector<vector<int>> cnt(m, vector<int>(26, 0));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cnt[j][words[i][j] - 'a']++;
        vector<vector<int>> dp(t, vector<int>(m, 0));
        for (int i = 0; i < m; i++)
            dp[0][i] = cnt[i][target[0] - 'a'];
        for (int i = 1; i < t; i++) {
            for (int j = i; j < m; j++) {
                for (int k = i - 1; k < j; k++)
                    dp[i][j] = (dp[i][j] + (long long)dp[i - 1][k] * cnt[j][target[i] - 'a']) % 1000000007;
            }
        }
        int res = 0;
        for (int i = t - 1; i < m; i++)
            res = (res + dp[t - 1][i]) % 1000000007;
        return res;
    }
};