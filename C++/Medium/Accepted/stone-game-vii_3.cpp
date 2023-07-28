class Solution {
public:
    int stoneGameVII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> sum(n+1);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i-1] + stones[i-1];
        }
        vector<vector<int>> dp(n, vector<int>(n));
        for (int i = n-2; i >= 0; --i) {
            for (int j = i+1; j < n; ++j) {
                dp[i][j] = max(sum[j+1]-sum[i+1]-dp[i+1][j], sum[j]-sum[i]-dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
};