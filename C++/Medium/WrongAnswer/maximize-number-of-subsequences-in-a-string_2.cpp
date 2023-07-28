class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        
        int n = text.size();
        int m = pattern.size();
        vector<vector<long long>> dp(n + 1, vector<long long>(m + 1, 0));
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if(text[i - 1] == pattern[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        long long ans = 0;
        for(int i = 0; i <= n; i++) {
            if(text[i] == pattern[0]) {
                ans += dp[i][1] * dp[n - i][1];
            }
        }
        return ans;
    }
};