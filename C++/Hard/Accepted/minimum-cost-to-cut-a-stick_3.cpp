class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        sort(cuts.begin(), cuts.end());
        cuts.insert(cuts.begin(), 0);
        cuts.push_back(n);
        int m = cuts.size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        for (int i = m - 1; i >= 0; --i) {
            for (int j = i + 1; j < m; ++j) {
                if (j - i == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INT_MAX;
                    for (int k = i + 1; k < j; ++k) {
                        dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                    dp[i][j] += cuts[j] - cuts[i];
                }
            }
        }
        return dp[0][m - 1];
    }
};