class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size();
        int n = colCosts.size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        dp[startPos[0]][startPos[1]] = 0;
        for (int i = startPos[0]; i < m; i++) {
            for (int j = startPos[1]; j < n; j++) {
                if (i == startPos[0] && j == startPos[1]) continue;
                if (i > 0) dp[i][j] = min(dp[i][j], dp[i - 1][j] + rowCosts[i]);
                if (j > 0) dp[i][j] = min(dp[i][j], dp[i][j - 1] + colCosts[j]);
            }
        }
        return dp[homePos[0]][homePos[1]];
    }
};