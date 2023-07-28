class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        
        int n = board.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> paths(n, vector<int>(n, 0));
        paths[n-1][n-1] = 1;
        int mod = pow(10, 9) + 7;
        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == n-1 && j == n-1) continue;
                if(board[i][j] == 'X') continue;
                int a = 0, b = 0, c = 0;
                if(i+1 < n) {
                    a = dp[i+1][j];
                    if(paths[i+1][j] > 0) b = paths[i+1][j];
                }
                if(j+1 < n) {
                    a = max(a, dp[i][j+1]);
                    if(paths[i][j+1] > 0) c = paths[i][j+1];
                }
                if(i+1 < n && j+1 < n) {
                    a = max(a, dp[i+1][j+1]);
                    if(paths[i+1][j+1] > 0) c = paths[i+1][j+1];
                }
                dp[i][j] = a + (board[i][j] == 'E' ? 0 : board[i][j] - '0');
                paths[i][j] = (b + c) % mod;
            }
        }
        return {dp[0][0], paths[0][0]};
    }
};