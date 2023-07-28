class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size();
        int n = colCosts.size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int startR = startPos[0];
        int startC = startPos[1];
        int homeR = homePos[0];
        int homeC = homePos[1];
        for (int i = startR; i < m; i++) {
            if (i == startR) {
                dp[i][startC] = rowCosts[i];
            } else {
                dp[i][startC] = dp[i - 1][startC] + rowCosts[i];
            }
        }
        for (int i = startC; i < n; i++) {
            if (i == startC) {
                dp[startR][i] = colCosts[i];
            } else {
                dp[startR][i] = dp[startR][i - 1] + colCosts[i];
            }
        }
        for (int i = startR + 1; i < m; i++) {
            for (int j = startC + 1; j < n; j++) {
                dp[i][j] = min(dp[i - 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
            }
        }
        return dp[homeR][homeC];
    }
};