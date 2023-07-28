class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        int m = ranges.size();
        vector<int> dp(m, m);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = max(0, i - ranges[i]); j <= min(m - 1, i + ranges[i]); j++) {
                dp[j] = min(dp[j], dp[max(0, i - ranges[i])] + 1);
            }
        }
        return dp[n] == m ? -1 : dp[n];
    }
};