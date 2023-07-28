class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        vector<int> dp(n+1, 0);
        for (int i = n-1; i >= 0; i--) {
            int j = i;
            while (j < n && days[j] - days[i] < 7) j++;
            int a = dp[j] + costs[1];
            while (j < n && days[j] - days[i] < 30) j++;
            int b = dp[j] + costs[2];
            dp[i] = min(a, b);
            dp[i] = min(dp[i], dp[i+1] + costs[0]);
        }
        return dp[0];
    }
};