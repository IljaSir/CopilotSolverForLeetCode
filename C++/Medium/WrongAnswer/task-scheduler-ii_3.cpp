class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        vector<int> last(n + 1, 0);
        vector<long long> dp(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (last[tasks[i - 1]] > 0) {
                dp[i] = min(dp[i], dp[last[tasks[i - 1]] - 1] + i - last[tasks[i - 1]]);
            }
            last[tasks[i - 1]] = i;
        }
        return dp[n];
    }
};