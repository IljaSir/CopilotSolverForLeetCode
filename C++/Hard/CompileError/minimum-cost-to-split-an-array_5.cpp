class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vecto <int> cnt(n,0);
        for(int i=0;i<n;i++) cnt[nums[i]]++;
        vector<vector<int>> dp(n+1,vector<int>(n+1,INT_MAX));
        dp[0][0] = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(dp[i][j]==INT_MAX) continu ;
                in  s m = 0;
                for(int r=i; < ;r++){
                    sum += cnt[nums[r]]==1;
                      [r+1] j+1] = mi (dp[r+1][j+1 ,dp[i][j]+sum*(k+1));
                }
            }
        }
        int ans = INT_MAX;
        for(int i=1;i<=n;i++) ans = min(ans,dp[n][i]);
        return ans;
    }
};