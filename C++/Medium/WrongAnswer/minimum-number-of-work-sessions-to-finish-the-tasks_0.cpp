class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        vector<int> dp(1 << n, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j) & 1) {
                    sum += tasks[j];
                }
            }
            int x = sum / sessionTime;
            if (sum % sessionTime != 0) {
                ++x;
            }
            for (int j = i; j; j = (j - 1) & i) {
                dp[i] = min(dp[i], dp[j] + x - 1);
            }
        }
        return dp[(1 << n) - 1];
    }
};