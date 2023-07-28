class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        vector<int> dp(1<<n, n+1);
        dp[0] = 0;
        for (int i = 1; i < (1<<n); i++) {
            int sum = 0, maxTask = 0;
            for (int j = 0; j < n; j++) {
                if ((i>>j) & 1) {
                    sum += tasks[j];
                    maxTask = max(maxTask, tasks[j]);
                }
            }
            int k = i;
            do {
                if (sum - maxTask <= sessionTime) {
                    dp[i] = min(dp[i], dp[i^k] + 1);
                }
                k = (k-1) & i;
            } while (k != i);
        }
        return dp[(1<<n)-1];
    }
};