class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> count(n, vector<int>(n, 0));
        count[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (board[i][j] == 'X') {
                    continue;
                }
                int val = board[i][j] == 'E' ? 0 : board[i][j] - '0';
                if (i == n - 1 && j == n - 1) {
                    dp[i][j] = val;
                    continue;
                }
                if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1] + val;
                    count[i][j] = count[i][j + 1];
                    continue;
                }
                if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j] + val;
                    count[i][j] = count[i + 1][j];
                    continue;
                }
                int maxVal = max(dp[i + 1][j], max(dp[i][j + 1], dp[i + 1][j + 1]));
                dp[i][j] = maxVal + val;
                if (dp[i + 1][j] == maxVal) {
                    count[i][j] += count[i + 1][j];
                    count[i][j] %= 1000000007;
                }
                if (dp[i][j + 1] == maxVal) {
                    count[i][j] += count[i][j + 1];
                    count[i][j] %= 1000000007;
                }
                if (dp[i + 1][j + 1] == maxVal) {
                    count[i][j] += count[i + 1][j + 1];
                    count[i][j] %= 1000000007;
                }
            }
        }
        return {dp[0][0], count[0][0]};
    }
};