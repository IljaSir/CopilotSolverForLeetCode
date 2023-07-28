class Solution {
public:
    int findGoodStrings(int n, string s1, string s2, string evil) {
        
        // dp[i][j][k] = number of good strings with prefix i and evil string of length j
        // and the last character of the prefix is k
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + ... + dp[i - 1][j - evil.size()][k]
        // dp[i][j][k] = dp[i -
    }
};