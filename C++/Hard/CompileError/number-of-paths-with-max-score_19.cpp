class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> cnt(n, vector<int>(n, 0));
        cnt[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] == 'X') continue;
                if (i == n - 1 && j == n - 1) continue;
                int val = board[i][j] - '0';
                if (i + 1 < n && j + 1 < n) {
                    if (dp[i + 1][j + 1] > dp[i][j]) {
                        dp[i][j] = dp[i + 1][j + 1];
                        cnt[i][j] = cnt[i + 1][j + 1];
                    } else if (dp[i + 1][j + 1] == dp[i][j]) {
                        cnt[i][j] += cnt[i + 1][j + 1];
                        cnt[i][j] %= 1000000007;
                    }
                }
                if (i + 1 < n) {
                    if (dp[i + 1][j] > dp[i][j]) {
                        dp[i][j] = dp[i + 1][j];
                        cnt[i][j] = cnt[i + 1][j];
                    } else if (dp[i + 1][j] == dp[i][j]) {
                        cnt[i][j] += cnt[i + 1][j];
                        cnt[i][j] %= 1000000007;
                    }
                }
                if (j + 1 < n) {
                    if (dp[i][j + 1] > dp[i][j]) {
                        dp[i][j] = dp[i][j + 1];
                        cnt[i][j] = cnt[i][j + 1];
                    } el e if (dp[i][j + 1] == dp[i][j]) {
                        cnt[i][j] += cnt[i][j + 1];
                        cnt[i][j] %= 1000000007;
                    }
                }
                dp[i][j
    }
};