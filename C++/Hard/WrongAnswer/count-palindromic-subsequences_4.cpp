class Solution {
public:
    int countPalindromes(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n));
        vector<vector<int>> sum(n, vector<int>(n));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            sum[i][i] = 1;
        }
        for (int len = 2; len <= 5; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s[i] == s[j]) {
                    dp[i][j] = sum[i + 1][j - 1] + 2;
                    if (len == 5) dp[i][j]++;
                } else {
                    dp[i][j] = sum[i + 1][j] + sum[i][j - 1] - sum[i + 1][j - 1];
                }
                sum[i][j] = dp[i][j] + sum[i][j - 1] + sum[i + 1][j] - sum[i + 1][j - 1];
            }
        }
        return dp[0][n - 1];
    }
};