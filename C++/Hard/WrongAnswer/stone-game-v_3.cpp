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
                    if (sum[k]-sum[i] < sum[j]-sum[k]) {
                        dp[i][j] = max(dp[i][j], dp[i][k]+sum[k]-sum[i]);
                    } else if (sum[k]-sum[i] > sum[j]-sum[k]) {
                        dp[i][j] = max(dp[i][j], dp[k][j]+sum[j]-sum[k]);
                    } else {
                        dp[i][j] = max(dp[i][j], dp[i][k]+dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n];
    }
};