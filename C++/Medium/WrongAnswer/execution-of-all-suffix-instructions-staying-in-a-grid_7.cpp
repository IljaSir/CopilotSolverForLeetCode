class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        int m = s.size();
        vector<int> res(m, 0);
        int x = startPos[0], y = startPos[1];
        vector<vector<int>> dp(m + 1, vector<int>(n * n, 0));
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n * n; ++j) {
                if (i == m - 1) {
                    dp[i][j] = 1;
                    continue;
                }
                int x = j / n;
                int y = j % n;
                if (s[i] == 'U') {
                    if (x - 1 < 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][(x - 1) * n + y];
                    }
                } else if (s[i] == 'D') {
                    if (x + 1 >= n) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][(x + 1) * n + y];
                    }
                } else if (s[i] == 'L') {
                    if (y - 1 < 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][x * n + y - 1];
                    }
                } else if (s[i] == 'R') {
                    if (y + 1 >= n) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][x * n + y + 1];
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            res[i] = dp[i][x * n + y];
        }
        return res;
    }
};