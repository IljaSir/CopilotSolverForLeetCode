class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        
        int n = text.length();
        int m = pattern.length();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        dp[0][0] = 1;
        for(int i = 1; i <= n; ++i){
            dp[i][0] = 1;
            for(int j = 1; j <= m; ++j){
                if(text[i-1] == pattern[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[n][m];
    }
};