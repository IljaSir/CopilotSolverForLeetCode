class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i < (1 << n); ++i) {
            int last = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    last = max(last, tasks[j][1]);
                }
            }
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    int prev = i - (1 << j);
                    dp[i] = min(dp[i], dp[prev] + max(0, tasks[j][0] - last) + tasks[j][2]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};