class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        int total = 0;
        for (int i = 0; i < n; ++i) {
            total += tasks[i];
        }
        int m = total / sessionTime + 1;
        vector<int> dp(1 << n, m);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    sum += tasks[j];
                }
            }
            int sessions = sum / sessionTime + (sum % sessionTime > 0);
            for (int j = i; j != 0; j = (j - 1) & i) {
                dp[i] = min(dp[i], dp[j] + sessions);
            }
        }
        return dp[(1 << n) - 1];
    }
};