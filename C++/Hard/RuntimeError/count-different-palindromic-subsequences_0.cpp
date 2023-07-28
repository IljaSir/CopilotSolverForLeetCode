class Solution {
public:
    int countPalindromicSubsequences(string s) {
        
        int n = s.size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(n, vector<int>(n));
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    int low = i + 1, high = j - 1;
                    while (low <= high && s[low] != s[j]) low++;
                    while (low <= high && s[high] != s[j]) high--;
                    if (low > high) dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    else if (low == high) dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    else dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                }
                else dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return dp[0][n - 1];
    }
};