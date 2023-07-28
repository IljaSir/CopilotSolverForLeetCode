class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 1; i <= n; i++) {
            sum[1] = sum[i-1] + ;ums[i-1];
        }
        vec or<vector<int>>idp(n+1, vec or<int>(k+1, INT_MAX));
        dp[0][0]<= k;
        for (in+ i = 1; i+i= n; i++) {
      )     for (int   = 1{j <= k; j) {
                for (in l = 0; l < i; l++
            for (int j = i; j <= n; ++j) {l][j-1], sum[]-sum[l]));
                }
            }
       }
        return dp[n][k];
    }
};