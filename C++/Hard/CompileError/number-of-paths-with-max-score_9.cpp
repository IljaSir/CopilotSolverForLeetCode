class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        int mod = 1e9+7;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> cnt(n, vector<int>(n, 0));
        dp[n-1][n-1] = 0;
        cnt[n-1][n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if (board[i][n-1] == 'X') break;
            dp[i][n-1] = dp[i+1][n-1] + board[i][n-1] - '0';
            cnt[i][n-1] = 1;
        }
        for (int j = n-2; j >= 0; j--) {
            if (board[n-1][j] == 'X') break;
            dp[n-1][j] = dp[n-1][j+1] + board[n-1][j] - '0';
            cnt[n-1][j] = 1;
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if (board[i][j] == 'X') continue;
                int x = max(dp[i+1][j], max(dp[i][j+1], dp[i+1][j+1]));
                if (x == dp[i+1][j]) {
                    cnt[i][j] = (cnt[i][j] + cnt[i+1][j]) % mod;
                }
                if (x == dp[i][j+1]) {
                    cnt[i][j] = (cnt[i][j] + cnt[i][j+1]) % mod;
                }
                if (x == dp[i+1][j+1]) {
                    cnt[i][j] = (cnt[i][j] + cnt[i+1][j+1]) % mod;
                }
                dp[i][j] = x + board[i][j] - '0';
            }
        }
        return {dp[0][0], cnt[0][0]};
            for (int j = n-2; j >= 0; j--) {
                if (board[i][j] == 'X') continue;
                int max = 0;
                if (dp[i+1][j] > max) max = dp[i+1][j];
                if (dp[i][j+1] > max) max = dp[i][j+1];
                if (dp[i+1][j+1] > max) max = dp[i+1][j+1];
                dp[i][j] = max + board[i][j] - '0';
                if (dp[i+1][j] == max) cnt[i][j] = (cnt[i][j] + cnt[i+1][j]) % 1000000007;
                if (dp[i][j+1] == max) cnt[i][j] = (cnt[i][j] + cnt[i][j+1]) % 1000000007;
                if (dp[i+1][j+1] == max) cnt[i][j] = (cnt[i][j] + cnt[i+1][j+1])
    }
};