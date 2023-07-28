class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> cnt(n, vector<int>(n, 0));
        dp[n-1][n-1] = 0;
        cnt[n-1][n-1] = 1;
        int mod = 1e9 + 7;
        for (int i = n-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (board[i][j] == 'X') {
                    continue;
                }
                if (i == n-1 && j == n-1) {
                    continue;
                }
                int a = 0, b = 0, c = 0;
                if (i + 1 < n && j < n) {
                    a = dp[i+1][j];
                    if (a > 0) {
                        cnt[i][j] += cnt[i+1][j];
                        cnt[i][j] %= mod;
                    }
                }
                if (i < n && j + 1 < n) {
                    b = dp[i][j+1];
                    if (b > 0) {
                        cnt[i][j] += cnt[i][j+1];
                        cnt[i][j] %= mod;
                    }
                }
                if (i + 1 < n && j + 1 < n) {
                    c = dp[i+1][j+1];
                    if (c > 0) {
                        cnt[i][j] += cnt[i+1][j+1];
                        cnt[i][j] %= mod;
                    }
                }
                dp[i][j] = max({a, b, c}) + (board[i][j] == 'S' ? 0 : board[i][j] - '0');
            }
        }
        return {dp[0][0], cnt[0][0]};
    }
};