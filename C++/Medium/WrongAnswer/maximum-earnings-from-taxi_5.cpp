class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        vector<long long> dp(n+1, 0);
        for (int i = rides.size() - 1; i >= 0; --i) {
            int start = rides[i][0], end = rides[i][1], tip = rides[i][2];
            int j = upper_bound(rides.begin(), rides.end(), vector<int>{end, 0, 0}) - rides.begin();
            dp[start] = max(dp[start], dp[end] + end - start + tip);
            dp[start] = max(dp[start], dp[start+1]);
        }
        return dp[1];
    }
};