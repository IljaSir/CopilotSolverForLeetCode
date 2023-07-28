class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int n = s.size();
        int dp[n][n]; // dp[i][j] = count of unique palindromic subsequences of length 3 in s[i..j] 
        memset(dp, 0, sizeof(dp));
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                    int l = i + 1, r = j - 1;
                    while (l <= r && s[l] != s[i]) l++;
                    while (l <= r && s[r] != s[j]) r--;
                    if (l > r) dp[i][j] += 2;
                    else if (l == r) dp[i][j] += 1;
                    else dp[i][j] -= dp[l + 1][r - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n - 1];
    }
};