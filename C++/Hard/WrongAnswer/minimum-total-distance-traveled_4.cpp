class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        int n = robot.size(), m = factory.size();
        vector<vector<long long>> dp(n + 1, vector<long long>(m + 1, 0));
        vector<long long> sum(n + 1, 0);
        sort(robot.begin(), robot.end());
        sort(factory.begin(), factory.end());
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + robot[i - 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + abs(robot[i - 1] - factory[j - 1][0]);
                if (i > factory[j - 1][1]) dp[i][j] = min(dp[i][j], dp[i - factory[j - 1][1] - 1][j - 1] + sum[i] - sum[i - factory[j - 1][1]]);
            }
        }
        return dp[n][m];
    }
};