class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int n = cost.size(), m = cost[0].size();
        vector<vector<int>> dp(n + 1, vector<int>(1 << m, 1e9));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < (1 << m); ++k) {
                    dp[i + 1][k | (1 << j)] = min(dp[i + 1][k | (1 << j)], dp[i][k] + cost[i][j]);
                }
            }
        }
        int ans = 1e9;
        for (int i = 0; i < (1 << m); ++i) {
            int cur = dp[n][i];
            for (int j = 0; j < m; ++j) {
                if (!(i & (1 << j))) {
                    cur += *min_element(cost.begin(), cost.end(), [j](auto& a, auto& b) { return a[j] < b[j]; })[j];
                }
            }
            ans = min(ans, cur);
        }
        return ans;
    }
};