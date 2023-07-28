class Solution {
public:
    int countVowelStrings(int n) {
        
        int dp[6][n+1];
        for(int i=0;i<6;i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for(int i=0;i<=n;i++) {
            dp[0][i] = 0;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<6;j++) {
                dp[j][i] = dp[j][i-1] + dp[j-1][i];
            }
        }
        return dp[5][n];
    }
};