class Solution {
public:
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        
        int kMax = 0x3f3f3f3f;
        vector<vector<vector<int>>> dp(m+1, vector<vector<int>>(n+1, vector<int>(target+1, kMax)));
        for (int i = 0; i <= n; i++) {
            dp[0][i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (houses[i-1] == 0) {
                        for (int l = 1; l <= n; l++) {
                            if (l == j) {
                                dp[i][j][k] = min(dp[i][j][k], dp[i-1][l][k] + cost[i-1][j-1]);
                            } else {
                                dp[i][j][k] = min(dp[i][j][k], dp[i-1][l][k-1] + cost[i-1][j-1]);
                            }
                        }
                    } else {
                        if (houses[i-1] == j) {
                            dp[i][j][k] = min(dp[i][j][k], dp[i-1][j][k]);
                        } else {
                            dp[i][j][k] = min(dp[i][j][k], dp[i-1][j][k-1]);
                        }
                    }
                }
            }
        }
        int ans = kMax;
        for (int i = 1; i <= n; i++) {
            ans = min(ans, dp[m][i][target]);
        }
        return ans == kMax ? -1 : ans;
    }
};