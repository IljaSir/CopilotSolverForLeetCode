class Solution {
public:
    long long sellingWood(int m, int n, vector<vector<int>>& prices) {
        
        long long dp[m+1][n+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                dp[i][j]=0;
        for(auto& p:prices){
            for(int i=m;i>=p[0];i--){
                for(int j=n;j>=p[1];j--){
                    dp[i][j]=max(dp[i][j],dp[i-p[0]][j-p[1]]+p[2]);
                }
            }
        }
        return dp[m][n];
    }
};