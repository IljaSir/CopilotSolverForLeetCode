class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        long long dp[n+1];
        memset(dp, 0, sizeof(dp));
        sort(rides.begin(), rides.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] < b[1];
        });
        int i = 0;
        for (int j = 1; j <= n; ++j) {
            dp[j] = max(dp[j], dp[j-1]);
            while (i < rides.size() && rides[i][1] == j) {
                dp[j] = max(dp[j], dp[rides[i][0]] + rides[i][1] - rides[i][0] + rides[i][2]);
                ++i;
            }
        }
        return dp[n];
    }
};