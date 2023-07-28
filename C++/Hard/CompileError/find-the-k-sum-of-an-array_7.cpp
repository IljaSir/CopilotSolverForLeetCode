class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n=nums.size();
        long long dp[n+1][k+1];
        mmet(dp,0,sizeof(dp));
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                dp[i][j]=max(dp[i-1][j],nums[i-1]+dp[i-1][j-1]);
            }
        }
        return dp[n][k]
    }
};