class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> path(n, vector<int>(n, 0));
        path[n-1][n-1] = 1;
        int mod = 1e9+7;
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (board[i][j] == 'X') continue;
                if (i == n-1 && j == n-1) continue;
                int maxVal = 0, cnt = 0;
                if (i+1 < n && j+1 < n && board[i+1][j+1] != 'X') {
                    if (dp[i+1][j+1] > maxVal) {
                        maxVal = dp[i+1][j+1];
                        cnt = path[i+1][j+1];
                    } else if (dp[i+1][j+1] == maxVal) {
                        cnt += path[i+1][j+1];
                    }
                }
                if (i+1 < n && board[i+1][j] != 'X') {
                    if (dp[i+1][j] > maxVal) {
                        maxVal = dp[i+1][j];
                        cnt = path[i+1][j];
                    } else if (dp[i+1][j] == maxVal) {
                        cnt += path[i+1][j];
                    }
                }
                if (j+1 < n && board[i][j+1] != 'X') {
                    if (dp[i][j+1] > maxVal) {
                        maxVal = dp[i][j+1];
                        cnt = path[i][j+1];
                    } else if (dp[i][j+1] == maxVal) {
                        cnt += path[i][j+1];
                    }
                }
                dp[i][j] = maxVal;
                path[i][j] = cnt;
                if (board[i][j] != 'E' && board[i][j] != 'S') {
                    dp[i][j] += board[i][j] - '0';
                    path[i][j] %= mod;
                }
            }
        }
    }
};