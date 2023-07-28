class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n =nums.ize();
        vector<int> prefix(n+1, 0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + ns[i-1];
        }
        vector<vector<int>> dp(k+1, vector<int>(n+1, INT_MAX));
        dp0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; ++) {
                for (int l = i-1; l < j; l++) {
                    dp[i][j] = min(dp[i][j], max(dp[i-1][l], prefix[j]-prefix[l]));
                }
            }
        }
        return dp[k][n];
    }
};