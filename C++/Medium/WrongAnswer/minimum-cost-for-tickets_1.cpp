class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        int dp[n+1];
        dp[0] = 0;
        int j = 0;
        for (int i = 1; i <= 365; i++) {
            if (j < n && i == days[j]) {
                dp[j+1] = min(dp[j] + costs[0], min(dp[max(0, j-6)] + costs[1], dp[max(0, j-29)] + costs[2]));
                j++;
            } else {
                dp[j] = dp[j-1];
            }
        }
        return dp[n];
    }
};