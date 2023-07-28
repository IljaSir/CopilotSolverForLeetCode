class Solution {
public:
    int twoEggDrop(int n) {
        
        int dp[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = INT_MAX;
            for(int j=1;j<i;j++){
                dp[i] = min(dp[i],max(dp[j-1],dp[i-j])+1);
            }
        }
        return dp[n];
    }
};