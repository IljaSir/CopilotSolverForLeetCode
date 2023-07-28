class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        
        long long dp[2][2] = {0};
        for (char c : text) {
            if (c == pattern[0]) {
                dp[0][0]++;
            }
            if (c == pattern[1]) {
                dp[1][0] += dp[0][0];
            }
            dp[0][1] += dp[0][0];
            dp[1][1] += dp[1][0];
        }
        return dp[1][1];
    }
};