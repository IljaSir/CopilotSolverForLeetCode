class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        sort(rides.begin(), rides.end(), [](auto &a, auto &b) {
            return a[0] < b[0];
        });
        vector<long long> dp(n + 1);
        int i = 0;
        for (int j = 1; j <= n; ++j) {
            dp[j] = max(dp[j], dp[j - 1]);
            while (i < rides.size() && j == rides[i][0]) {
                dp[rides[i][1]] = max(dp[rides[i][1]], dp[j] + rides[i][1] - rides[i][0] + rides[i][2]);
                ++i;
            }
        }
        return dp[n];
    }
};