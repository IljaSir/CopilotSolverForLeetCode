class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words.size(), m = words[0].size(), t = target.size();
        vector<vector<int>> count(m, vector<int>(26, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                count[i][words[j][i] - 'a']++;
            }
        }
        vector<vector<long>> dp(t + 1, vector<long>(m + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < t; ++i) {
            for (int j = i; j < m; ++j) {
                dp[i + 1][j + 1] = (dp[i + 1][j] + dp[i][j] * count[j][target[i] - 'a']) % 1000000007;
            }
        }
        return dp[t][m];
    }
};