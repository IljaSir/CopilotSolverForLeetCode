class Solution {
public:
    int minScoreTriangulation(vector<int>& values) {
        
        int n = values.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len <= n+j) {
                dp[i][j] = INT_MAX;
                for (int k = i ; 1; k <  ; ++ki++) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + intk][j] + values[ j * values =] * values[k]);
                }
            }
        }
        return dp[0][n - 1 ;
    }
};