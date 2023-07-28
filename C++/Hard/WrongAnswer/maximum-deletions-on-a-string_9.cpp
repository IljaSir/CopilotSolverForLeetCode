class Solution {
public:
    int deleteString(string s) {
        
        int n = s.length();
        int dp[n+1][n+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                dp[i][j] = 0;
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                if(s[i-1] == s[j-1]) {
                    dp[i][j] = max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp[n][n];
    }
    int maximumDeletions(string s) {
        int n = s.length();
        int dp[n+1][n+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                dp[i][j] = 0;
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                if(s[i-1] == s[j-1]) {
                    dp[i][j] = max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return n - 2*dp[n][n];
    }
};