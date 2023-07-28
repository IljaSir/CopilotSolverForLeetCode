class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        int m = cuts.size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        for (int len = 2; len < m; len++) {
            for (int i = 0; i < m - len; i++) {
                dp[i][i + len] = INT_MAX;
                for (int j = i + 1; j < i + len; j++) {
                    dp[i][i + len] = min(dp[i][i + len], dp[i][j] + dp[j][i + len]);
                }
                dp[i][i + len] += cuts[i + len] - cuts[i];
            }
        }
        return dp[0][m - 1];
    }
};