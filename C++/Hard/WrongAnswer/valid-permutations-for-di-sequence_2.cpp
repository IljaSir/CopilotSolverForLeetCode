class Solution {
public:
    int numPermsDISequence(string s) {
        
        int n = s.size();
        int M = 1000000007;
        vector<vector<long>> dp(n+1, vector<long>(n+1, 0));
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(s[i-1]=='D'){
                    for(int k=j;k<=n-1;k++){
                        dp[i][j] = (dp[i][j] + dp[i-1][k]) % M;
                    }
                }else{
                    for(int k=0;k<j;k++){
                        dp[i][j] = (dp[i][j] + dp[i-1][k]) % M;
                    }
                }
            }
        }
        long res = 0;
        for(int i=0;i<=n;i++){
            res = (res + dp[n][i]) % M;
        }
        return res;
    }
};