class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        sort(rides.begin(), rides.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        vector<long long> dp(n + 1, 0);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = max(dp[i], dp[i - 1]);
            while (j < rides.size() && rides[j][1] == i) {
                dp[i] = max(dp[i], dp[rides[j][0]] + rides[j][2] + rides[j][1] - rides[j][0]);
                j++;
            }
        }
        return dp[n];
    }
};