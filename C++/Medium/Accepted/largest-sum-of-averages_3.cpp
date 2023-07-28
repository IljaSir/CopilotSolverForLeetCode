class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for(int i=0; i<n; i++) sum[i+1] = sum[i] + nums[i];
        vector<vector<double>> dp(n, vector<double>(k+1, 0));
        for(int i=0; i<n; i++) dp[i][1] = (sum[n]-sum[i])/(double)(n-i);
        for(int i=n-2; i>=0; i--)
            for(int j=2; j<=k; j++)
                for(int l=i+1; l<n; l++)
                    dp[i][j] = max(dp[i][j], dp[l][j-1] + (sum[l]-sum[i])/(double)(l-i));
        return dp[0][k];
    }
};