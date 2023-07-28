class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        int m = cuts.size();
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        vector<int> sum(m+2, 0);
        for (int i = 1; i <= m+1; i++) {
            sum[i] = sum[i-1] + cuts[i] - cuts[i-1];
        }
        vector<vector<int>> dp(m+2, vector<int>(m+2, 0));
        for (int i = m; i >= 0; i--) {
            for (int j = i+2; j <= m+1; j++) {
                dp[i][j] = INT_MAX;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + sum[j] - sum[i]);
                }
            }
        }
        return dp[0][m+1];
    }
};