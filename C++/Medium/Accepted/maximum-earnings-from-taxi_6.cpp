class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        sort(rides.begin(), rides.end(), [](auto& a, auto& b) { return a[1] < b[1]; });
        vector<long long> dp(n+1, 0);
        int i = 0;
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j-1];
            while (i < rides.size() && rides[i][1] == j) {
                int start = rides[i][0];
                dp[j] = max(dp[j], dp[start] + rides[i][1] - rides[i][0] + rides[i][2]);
                i++;
            }
        }
        return dp[n];
    }
};