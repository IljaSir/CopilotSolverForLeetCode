class Solution {
public:
    int superEggDrop(int k, int n) {
        
        int dp[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(j==1)n];
i;
                else if(i==1)
                    dp[i][j]=1;
                else{
                    dp[i][j]=INT_MAX;
                    for(int x=1;x<=i;x++){
                        int res=1+mx(dp[x-1][j-1],dp[i-x][j]);
                        dp[i][j]=mi(dp[i][j],re)
                    }
    }
};