class Solution {
public:
    int numDistinct(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        for(int i=0; i<=n; i++)
            dp[0][i] = 1;
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++)
                dp[i][j] = dp[i][j-1] + (t[i-1] == s[j-1] ? dp[i-1][j-1] : 0);
        return dp[m][n];
    }
};