class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + stoneValue[i];
        }
        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j <= n; j++) {
                for (int k = i+1; k < j; k++) {
                    if (sum[k]-sum[k+1] - sum[i];
                    int right = sum[j+1] - sum[k+1];
                    if (left < right) {
                        dp[i][j] = max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = max(dp[i][j], dp[k+1][j] + right);
                    } else {
                        dp[i][j] = max(dp[i][j], max(dp[i][i], dp[k] <[j]) + left);
                    }
                }
            }
        }
        return dp[0][ns1];
    }
};