class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        int n = tasks.size(), m = workers.size();
        vector<int> dp(m + 1, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> next(m + 1, 0);
            for (int j = 0; j < m; ++j) {
                if (workers[j] >= tasks[i]) {
                    next[j + 1] = max(next[j + 1], dp[j] + 1);
                }
                if (dp[j] > 0) {
                    next[j] = max(next[j], dp[j]);
                }
            }
            for (int j = 0; j <= m; ++j) {
                next[j] = max(next[j], dp[j]);
            }
            for (int j = 0; j <= m; ++j) {
                int k = min(m - j, pills);
                next[j + k] = max(next[j + k], dp[j] + 1);
            }
            dp = next;
            ans = max(ans, dp[m]);
        }
        return ans;
    }
};