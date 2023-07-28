class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        vector<int> res(s.size(), 0);
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
                if (i > 0 && j > 0) dp[i][j] -= dp[i - 1][j - 1];
                dp[i][j] += 1;
            }
        }
        int x = startPos[0];
        int y = startPos[1];
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == 'L') {
                res[i] = dp[x][y] - dp[x][0];
                y = 0;
            }
            if (s[i] == 'R') {
                res[i] = dp[x][n - 1] - dp[x][y];
                y = n - 1;
            }
            if (s[i] == 'U') {
                res[i] = dp[x][y] - dp[0][y];
                x = 0;
            }
            if (s[i] == 'D') {
                res[i] = dp[n - 1][y] - dp[x][y];
                x = n - 1;
            }
        }
        return res;
    }
};