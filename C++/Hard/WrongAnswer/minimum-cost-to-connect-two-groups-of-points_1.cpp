class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int n = cost.size(), m = cost[0].size();
        vector<vector<int>> dp(n+1, vector<int>(1<<m, 1e9));
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1<<m); j++) {
                for (int k = 0; k < m; k++) {
                    dp[i+1][j|(1<<k)] = min(dp[i+1][j|(1<<k)], dp[i][j] + cost[i][k]);
                }
            }
        }
        vector<vector<int>> dp2(1<<m, vector<int>(1<<m, 1e9));
        for (int i = 0; i < (1<<m); i++) {
            for (int j = 0; j < (1<<m); j++) {
                for (int k = 0; k < m; k++) {
                    if ((i&(1<<k)) == 0 && (j&(1<<k)) == 0) {
                        dp2[i][j|(1<<k)] = min(dp2[i][j|(1<<k)], dp2[i][j] + cost[n-1][k]);
                    }
                }
            }
        }
        int ans = 1e9;
        for (int i = 0; i < (1<<m); i++) {
            ans = min(ans, dp2[i][(1<<m)-1] + dp[n][i]);
        }
        return ans;
    }
};