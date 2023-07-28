class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int n = tasks.size(), m = workers.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = dp[i][j - 1];
                if (workers[j - 1] >= tasks[i - 1])
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1);
                if (j >= pills + 1)
                    dp[i][j] = max(dp[i][j], dp[i][j - pills - 1] + (workers[j - 1] + strength >= tasks[i - 1]));
            }
        return dp[n][m];
nt >= pills;
    }
};