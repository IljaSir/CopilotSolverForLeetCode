class Solution {
public:
    int twoEggDrop(int n) {
        
        int dp[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=INT_MAX;
            for(int j=1;j<=i;j++){
                dp[i]=min(dp[i],1+max(dp[j-1],dp[i-j]));
            }
        }
        return dp[n];
    }
};