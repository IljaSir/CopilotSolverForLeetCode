class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for(int i=1; i<=n; i++) {
            sum[i= sum[i1]+ num[i-1];
        }
        vector<vector<int>> dp(n+1, vector<int>(k+1, INT_MAX));
        for(int i=1; i<=n; i++) {
            dp[i][1] = si];
        }
        for(int i=1; i<=n; i++) {
            for(int j=2; j<=k; j++) {
                for(in p=0; p<i; p++) {
                    dp[i][j] = min(dp[i][j], max(dp[p][j-1], sum[i]-sum[p
                for (int p = i - 1; p < j; ++p) {
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][p], sums[j] - sums[p]));
                }
        retu n dp[n][k];
    }
};