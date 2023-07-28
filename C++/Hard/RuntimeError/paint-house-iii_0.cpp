class Solution {
public:
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n + 1, vector<int>(target + 1, INT_MAX)));
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (i == 0) {
                        if (k == 1) {
                            if (houses[i] == 0 || houses[i] == j) {
                                dp[i][j][k] = houses[i] == 0 ? cost[i][j - 1] : 0;
                            }
                        }
                    } else {
                        if (houses[i] == 0 || houses[i] == j) {
                            int curCost = houses[i] == 0 ? cost[i][j - 1] : 0;
                            for (int p = 1; p <= n; p++) {
                                if (j == p) {
                                    dp[i][j][k] = min(dp[i][j][k], dp[i - 1][p][k] + curCost);
                                } else {
                                    if (k > 1) {
                                        dp[i][j][k] = min(dp[i][j][k], dp[i - 1][p][k - 1] + curCost);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int result = INT_MAX;
        for (int i = 1; i <= n; i++) {
            result = min(result, dp[m - 1][i][target]);
        }
        return result == INT_MAX ? -1 : result;
    }
};