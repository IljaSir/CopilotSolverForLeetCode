class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        vector<int> dp(n + 1, 1000000);
        dp[0] = 0;
        for (int i = 0; i <= n; ++i) {
            int l = max(0, i - ranges[i]), r = min(n, i + ranges[i]);
            for (int j = l; j < r; ++j) {
                dp[j + 1] = min(dp[j + 1], dp[l] + 1);
            }
        }
        return dp[n] == 1000000 ? -1 : dp[n];
    }
};