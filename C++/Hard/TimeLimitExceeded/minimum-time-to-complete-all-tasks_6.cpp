class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        vector<vector<int>> dp(2001, vector<int>(2001, 0));
        for (int i = 1; i <= 2000; ++i) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= 2000; ++len) {
            for (int i = 1; i + len - 1 <= 2000; ++i) {
                int j = i + len - 1;
                dp[i][j] = j - i + 1;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                for (auto& task: tasks) {
                    if (i == task[0] && j == task[1]) {
                        dp[i][j] = min(dp[i][j], task[2]);
                    }
                }
            }
        }
        return dp[1][2000];
    }
};