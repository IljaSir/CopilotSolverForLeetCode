class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
        for (int i = 1; i <= n; ++i) {
            dp[i][i] = tasks[i-1][2];
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 1; i <= n-len+1; ++i) {
                int j = i+len-1;
                dp[i][j] = dp[i+1][j] + tasks[i-1][2];
                for (int k = i+1; k <= j; ++k) {
                    if (tasks[k-1][1] < tasks[i-1][0]) {
                        dp[i][j] = min(dp[i][j], dp[i][k-1] + dp[k][j]);
                    }
                }
            }
        }
        return dp[1][n];
    }
};