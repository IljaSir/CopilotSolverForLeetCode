class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        int n = types.size();
        vector<vector<int>> dp(n+1, vector<int>(target+1));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 1; k <= types[i-1][0] && k*types[i-1][1] <= j; k++) {
                    dp[i][j] += dp[i-1][j-k*types[i-1][1]];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n][target];
    }
};