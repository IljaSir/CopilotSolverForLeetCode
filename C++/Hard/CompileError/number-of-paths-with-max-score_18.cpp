class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> pat(n, vector<int>(n, 0));
        dp[n-1][n-1] = 0;
        cnt[n-1][n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if (board[i][n-1] != 'X') {
                dp[i][n-1] = dp[i+1][n-1] + board[i][n-1] - '0';
                cnt[i][n-1] = cnt[i+1][n-1];
            }
        }
        for (int j = n-2; j >= 0; j--) {
            if (board[n-1][j] != 'X') {
                dp[n-1][j] = dp[n-1][j+1] + board[n-1][j] - '0';
                cnt[n-1][j] = cnt[n-1][j+1];
            }
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if (board[i][j] == 'X') continue;
                int max = 0;
                if (dp[i+1][j] > max) max = dp[i+1][j];
                if (dp[i][j+1] > max) max = dp[i][j+1];
                if (dp[i+1][j+1] > max) max = dp[i+1][j+1];
                dp[i][j] = max + board[i][j] - '0';
                if (dp[i+1][j] == max) cnt[i][j] = (cnt[i][j] + cnt[i+1][j]) % 1000000007;
                if (dp[i][j+1]s[0][0]};
    }
};