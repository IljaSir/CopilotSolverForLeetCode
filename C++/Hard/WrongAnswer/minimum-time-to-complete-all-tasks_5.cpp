class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        if (tasks.empty()) return 0;
        sort(tasks.begin(), tasks.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0];
        });
        
        int n = tasks.size();
        vector<int> dp(n, 0);
        dp[0] = tasks[0][2];
        for (int i = 1; i < n; ++i) {
            int end = tasks[i][0] - 1;
            int j = i - 1;
            while (j >= 0 && tasks[j][1] > end) {
                --j;
            }
            dp[i] = tasks[i][2] + (j < 0 ? 0 : dp[j]);
            if (i > 0) dp[i] = min(dp[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
};