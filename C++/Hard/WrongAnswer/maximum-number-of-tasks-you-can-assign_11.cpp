class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        int n = tasks.size();
        int m = workers.size();
        vector<int> dp(1 << m, -1);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << m); ++mask) {
            int i = 0;
            while ((mask & (1 << i)) == 0) ++i;
            int sub = mask ^ (1 << i);
            for (int j = 0; j < n; ++j) {
                if (dp[sub] >= 0 && dp[sub] + workers[i] + pills * strength >= tasks[j]) {
                    dp[mask] = max(dp[mask], dp[sub] + workers[i] + pills * strength - tasks[j]);
                }
            }
        }
        int res = 0;
        for (int mask = 0; mask < (1 << m); ++mask) {
            if (dp[mask] >= 0) {
                res = max(res, __builtin_popcount(mask));
            }
        }
        return res;
    }
};