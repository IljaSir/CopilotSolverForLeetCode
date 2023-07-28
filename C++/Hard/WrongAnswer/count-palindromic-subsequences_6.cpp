class Solution {
public:
    int countPalindromes(string s) {
        
        int n = s.length();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        for(int l=1; l<=5; l++) {
            for(int i=0; i+l<=n; i++) {
                int j = i+l-1;
                if(l==1) {
                    dp[i][j] = 1;
                } else if(l==2) {
                    if(s[i] == s[j]) {
                        dp[i][j] = 3;
                    } else {
                        dp[i][j] = 2;
                    }
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    if(s[i] == s[j]) {
                        dp[i][j] += dp[i+1][j-1] + 1;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
};