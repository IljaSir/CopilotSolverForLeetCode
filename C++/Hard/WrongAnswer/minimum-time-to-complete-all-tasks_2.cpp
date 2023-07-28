class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> dp(2001, 0);
        for (int i = 0; i < n; ++i) {
            int start = tasks[i][0], end = tasks[i][1], duration = tasks[i][2];
            dp[start] += duration;
            dp[end + 1] -= duration;
        }
        int ans = 0, cur = 0;
        for (int i = 1; i <= 2000; ++i) {
            cur += dp[i];
            ans = max(ans, cur);
        }
        return ans;
    }
};