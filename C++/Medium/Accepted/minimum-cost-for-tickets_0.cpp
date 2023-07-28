class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days[days.size() - 1];
        vector<int> dp(n + 1, 0);
        for (int i = 1, j = 0; i <= n; i++) {
            if (i == days[j]) {
                dp[i] = min(dp[i - 1] + costs[0], min(dp[max(0, i - 7)] + costs[1], dp[max(0, i - 30)] + costs[2]));
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
};