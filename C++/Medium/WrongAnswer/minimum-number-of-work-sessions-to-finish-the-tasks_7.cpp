class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        vector<int> dp(1<<n, 0);
        for (int i=1; i<(1<<n); i++) {
            int j = __builtin_ctz(i);
            dp[i] = dp[i^(1<<j)] + tasks[j];
            if (dp[i] > sessionTime) {
                dp[i] = tasks[j];
            }
        }
        vector<int> dp2(1<<n, n);
        dp2[0] = 0;
        for (int i=1; i<(1<<n); i++) {
            int x = i;
            do {
                dp2[i] = min(dp2[i], dp2[i^x] + 1);
                x = (x-1) & i;
            } while (x != i);
        }
        return dp2[(1<<n)-1];
    }
};