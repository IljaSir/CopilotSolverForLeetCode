class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        vector<int> dp(1 << n, 0);
        for (int mask = 0; mask < (1 << n); ++mask) {
            int time = 0;
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    time += tasks[i];
                }
            }
            if (time <= sessionTime) {
                dp[mask] = 1;
            } else {
                for (int i = 0; i < n; ++i) {
                    if (mask & (1 << i)) {
                        dp[mask] = max(dp[mask], dp[mask ^ (1 << i)]);
                    }
                }
            }
        }
        vector<int> dp2(1 << n, n);
        for (int mask = 0; mask < (1 << n); ++mask) {
            dp2[mask] = dp[mask];
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    dp2[mask] = min(dp2[mask], dp2[mask ^ (1 << i)] + dp[mask ^ (1 << i)]);
                }
            }
        }
        return dp2[(1 << n) - 1];
    }
};