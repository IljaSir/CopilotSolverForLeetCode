class Solution {
public:
    int minimumCost(vector<int>& cost) {
        
        int n = cost.size();
        if (n == 1) return cost[0];
        if (n == 2) return cost[0] + cost[1];
        int dp[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        dp[2] = cost[2];
        for (int i = 3; i < n; i++) {
            dp[i] = cost[i] + min(dp[i-1], dp[i-2]);
        }
        return dp[n-1];
    }
};