class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int n = tasks.size(), m = workers.size();
        vector<int> dp(m + 1);
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < m && workers[j] + pills * strength < tasks[i]) ++j;
            dp[i + 1] = max(dp[i + 1], dp[i]);
            if (j < m) dp[i + 1] = max(dp[i + 1], dp[j] + 1);
        }
        return dp[n];
    }
};