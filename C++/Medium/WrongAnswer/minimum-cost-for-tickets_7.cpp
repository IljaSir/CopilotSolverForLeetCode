class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        int dp[366];
        dp[0] = 0;
        for (int i = 1; i < 366; i++) {
            dp[i] = 0x3f3f3f3f;
        }
        for (int i = 0; i < n; i++) {
            dp[days[i]] = 0x3f3f3f3f;
        }
        for (int i = 1; i < 366; i++) {
            if (dp[i] == 0x3f3f3f3f) {
                dp[i] = min(dp[i - 1] + costs[0], min(dp[max(i - 7, 0)] + costs[1], dp[max(i - 30, 0)] + costs[2]));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[365];
    }
};