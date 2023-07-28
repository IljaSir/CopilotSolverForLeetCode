class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> cnt(n, vector<int>(n, 0));
        dp[n - 1][n - 1] = 0;
        cnt[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] == 'X') continue;
                if (i == n - 1 && j == n - 1) continue;
                if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1];
                    cnt[i][j] = cnt[i][j + 1];
                } else if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j];
                    cnt[i][j] = cnt[i + 1][j];
                } else {
                    int a = dp[i + 1][j];
                    int b = dp[i][j + 1];
                    int c = dp[i + 1][j + 1];
                    int max_dp = max(a, max(b, c));
                    dp[i][j] = max_dp;
                    if (a == max_dp) cnt[i][j] = (cnt[i][j] + cnt[i + 1][j]) % 1000000007;
                    if (b == max_dp) cnt[i][j] = (cnt[i][j] + cnt[i][j + 1]) % 1000000007;
                    if (c == max_dp) cnt[i][j] = (cnt[i][j] + cnt[i + 1][j + 1]) % 1000000007;
                }
                if (board[i][j] != 'S' && board[i][j] != 'E') {
                    dp[i][j] += (board[i][j] - '0');
                }
            }
        }
        if (dp[0][0] == 0) return {0, 0};
        return {dp[0][0], cnt[0][0]};
    }
};