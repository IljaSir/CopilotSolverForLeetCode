class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> dp(1<<n, 0);
        for (int i = 1; i < (1<<n); ++i) {
            int x = __builtin_ctz(i);
            int mask = i ^ (1<<x);
            dp[i] = dp[mask] + tasks[x][2];
            for (int y = 0; y < n; ++y) {
                if (i & (1<<y) && tasks[y][0] <= tasks[x][1]) {
                    dp[i] = max(dp[i], dp[mask | (1<<y)] + tasks[x][2]);
                }
            }
            for (int y = x + 1; y < n; ++y) {
                if (i & (1<<y) && tasks[y][0] <= tasks[x][1]) {
                    dp[i] = max(dp[i], dp[mask | (1<<y)] + tasks[x][2]);
                }
            }
        }
        
        return *max_element(dp.begin(), dp.end());
    }
};