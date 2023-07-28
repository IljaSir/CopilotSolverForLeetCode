class Solution {
public:
    int minSessions(vector<int>& tasks, int sessionTime) {
        
        int n = tasks.size();
        int ans = INT_MAX;
        vector<int> dp(1<<n, -1);
        dp[0] = 0;
        for(int mask = 0; mask < (1<<n); mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            int rem = sessionTime;
            for(int i = 0; i < n; i++) {
                if ((mask & (1<<i)) == 0) {
                    if (rem >= tasks[i]) {
                        dp[mask | (1<<i)] = max(dp[mask | (1<<i)], dp[mask]);
                    } else {
                        dp[mask | (1<<i)] = max(dp[mask | (1<<i)], dp[mask] + 1);
                    }
                    rem = min(rem, sessionTime - tasks[i]);
                }
            }
            ans = min(ans, dp[mask] + (rem < sessionTime));
        }
        return ans;
    }
};