class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        int dp[n];
        dp[0] = min({costs[0], costs[1], costs[2]});
        for (int i = 1; i < n; i ++) {
            dp[i] = dp[i - 1] + costs[0];
            for (int j = i - 1; j >= 0; j --) {
                if (days[i] - days[j] < 7) {
                    dp[i] = min(dp[i], dp[j] + costs[1]);
                    break;
                }
            }
            for (int j = i - 1; j >= 0; j --) {
                if (days[i] - days[j] < 30) {
                    dp[i] = min(dp[i], dp[j] + costs[2]);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
};