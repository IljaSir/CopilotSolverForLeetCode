class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words[0].size(), m = target.size();
        vector<vector<int>> cnt(n, vector<int>(26, 0));
        for (auto& s : words) {
            for (int i = 0; i < n; i++) {
                cnt[i][s[i] - 'a']++;
            }
        }
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[0][i] = cnt[i][target[0] - 'a'];
        }
        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i - 1; k < j; k++) {
                    dp[i][j] += dp[i - 1][k] * cnt[j][target[i] - 'a'];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        int ans = 0;
        for (int i = m - 1; i < n; i++) {
            ans += dp[m - 1][i];
            ans %= 1000000007;
        }
        return ans;
    }
};