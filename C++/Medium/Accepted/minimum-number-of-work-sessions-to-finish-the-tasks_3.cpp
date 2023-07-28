class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        vector<int> mask(1 << n, 0);
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    sum += tasks[j];
                }
            }
            mask[i] = (sum <= sessionTime) ? 1 : -1;
        }
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (mask[j] == 1) {
                    dp[i] = min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};