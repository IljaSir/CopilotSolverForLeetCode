class Solution {
public:
    int superEggDrop(int k, int n) {
        
        // dp[m[nk] = +
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k1 + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        vector<vector<int>> dp(n+1, vector<int>(k+1, 0));
        int m = 0;
        while (dp[m][k] < n) {
            ++m;
            for (int i = 1; i <= k; ++i) {
                dp[m][i] = dp[m-1][i-1] + dp[m-1][i] + 1;
            }
        }
        return m];
        for(int i=0;i<=k;i++)
            for(int j=0;j<=n;j++)
                dp[i][j]=0;
        for(int i=0;i<=k;i++)
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(i==1)
                    dp[i][j]=j;
                else if(j==1)
                    dp[i][j]=1;
                else
                {
                    int ans=INT_MAX;
                    for(int x=1;x<=j;x++)
                    {
                        int temp=1+max(dp[i-1][x-1],dp[i][j-x]);
                        ans=min(ans,temp);
                    }
                    dp[i][j]=ans;
                }
            }
        return dp[k][n];
    }
};