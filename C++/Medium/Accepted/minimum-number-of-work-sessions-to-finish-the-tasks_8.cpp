class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size(), ans = INT_MAX;
        vector<int> mask(1 << n);
        for (int i = 1; i < (1 << n); i++) {
            int last = __builtin_ctz(i);
            mask[i] = mask[i ^ (1 << last)] + tasks[last];
        }
        vector<int> dp(1 << n, INT_MAX / 2);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            int time = 0;
            for (int j = i; j; j = (j - 1) & i) {
                if (mask[j] <= sessionTime) {
                    dp[i] = min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};