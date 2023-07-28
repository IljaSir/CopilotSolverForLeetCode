class Solution {
public:
    int numPermsDISequence(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s[i - 1] == 'I') {
                for (int j = 0; j < i; ++j) {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 1000000007;
                    }
                }
            } else {
                for (int j = 0; j < i; ++j) {
                    for (int k = 0; k <= j; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            ans = (ans + dp[n][i]) % 1000000007;
        }
        return ans;
    }
};