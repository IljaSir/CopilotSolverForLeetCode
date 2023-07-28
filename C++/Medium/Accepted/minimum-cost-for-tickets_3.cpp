class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        vector<int> dp(366, 0);
        int dayIndex = 0;
        for (int i = 1; i <= 365; i++) {
            if (dayIndex < days.size() && i == days[dayIndex]) {
                dp[i] = min(dp[i-1] + costs[0], min(dp[max(0, i-7)] + costs[1], dp[max(0, i-30)] + costs[2]));
                dayIndex++;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[365];
    }
};