class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MIN));
        vector<vector<int>> cnt(n, vector<int>(n, 0));
        dp[n-1][n-1] = 0;
        cnt[n-1][n-1] = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (board[i][j] == 'X') {
                    dp[i][j] = INT_MIN;
                    continue;
                }
                if (i == n-1 && j == n-1) continue;
                int maxScore = INT_MIN, maxCnt = 0;
                for (int k = 0; k < 3; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    if (dp[x][y] == INT_MIN) continue;
                    if (dp[x][y] > maxScore) {
                        maxScore = dp[x][y];
                        maxCnt = cnt[x][y];
                    } else if (dp[x][y] == maxScore) {
                        maxCnt = (maxCnt + cnt[x][y]) % MOD;
                    }
                }
                if (maxScore == INT_MIN) continue;
                dp[i][j] = maxScore + (board[i][j] == 'E' ? 0 : board[i][j] - '0');
                cnt[i][j] = maxCnt;
            }
        }
        return {dp[0][0], cnt[0][0]};
    }
};