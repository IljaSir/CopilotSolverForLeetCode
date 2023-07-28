class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        int m = 1 << n;
        int dp[m];
        memset(dp, 0x3f, sizeof(dp));
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    sum += tasks[j];
                }
            }
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    continue;
                }
                if (sum + tasks[j] <= sessionTime) {
                    dp[i | (1 << j)] = min(dp[i | (1 << j)], dp[i]);
                } else {
                    dp[i | (1 << j)] = min(dp[i | (1 << j)], dp[i] + 1);
                }
            }
        }
        return dp[m - 1];
    }
};