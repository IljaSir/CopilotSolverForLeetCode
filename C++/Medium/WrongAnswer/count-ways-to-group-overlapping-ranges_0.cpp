class Solution {
public:
    int countWays(vector<vector<int>>& ranges) {
        
        sort(ranges.begin(), ranges.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0];
        });
        int n = ranges.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        int ans = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            int j = i;
            int mx = ranges[i][1];
            while (j < n && ranges[j][0] <= mx) {
                mx = max(mx, ranges[j][1]);
                ++j;
            }
            int c = j - i;
            for (int k = i + 1; k <= j; ++k) {
                dp[k] = (dp[k] + dp[k - 1]) % mod;
            }
            ans = (ans + dp[j] - dp[i]) % mod;
            i = j - 1;
        }
        return (ans + mod) % mod;
    }
};