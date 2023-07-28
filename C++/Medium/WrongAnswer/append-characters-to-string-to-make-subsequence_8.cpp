class Solution {
public:
    int appendCharacters(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(j==0) dp[i][j] = 0;
                else if(i==0) dp[i][j] = m;
                else if(s[i-1]==t[j-1]) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j]+1;
            }
        }
        return dp[n][m];
    }
};