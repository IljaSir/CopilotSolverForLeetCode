class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); ++i) {
            int maxEnd = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    maxEnd = max(maxEnd, tasks[j][1]);
                }
            }
            for (int j = 0; j < n; ++j) {
                if (!(i & (1 << j)) && tasks[j][0] >= maxEnd) {
                    dp[i | (1 << j)] = min(dp[i | (1 << j)], dp[i] + tasks[j][2]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};