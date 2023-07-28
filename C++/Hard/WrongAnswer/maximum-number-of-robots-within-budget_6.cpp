class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<vector<long long>> dp(n + 1, vector<long long>(n + 1, 0));
        vector<long long> sum(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + runningCosts[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = chargeTimes[i - 1] + sum[i];
                } else {
                    dp[i][j] = max(dp[i - 1][j], chargeTimes[i - 1] + (j - i + 1) * sum[i] + sum[j] - sum[i]);
                }
                if (dp[i][j] <= budget) {
                    ans = max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
};