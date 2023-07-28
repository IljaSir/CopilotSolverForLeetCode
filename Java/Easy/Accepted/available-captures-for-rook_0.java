class Solution {
    public int numRookCaptures(char[][] board) {
        
        int x = 0, y = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = x + 1; i < 8; ++i) {
            if (board[i][y] == 'p') {
                ans++;
                break;
            }
            if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x - 1; i >= 0; --i) {
            if (board[i][y] == 'p') {
                ans++;
                break;
            }
            if (board[i][y] == 'B') {
                break;
            }
        }
        for (int j = y + 1; j < 8; ++j) {
            if (board[x][j] == 'p') {
                ans++;
                break;
            }
            if (board[x][j] == 'B') {
                break;
            }
        }
        for (int j = y - 1; j >= 0; --j) {
            if (board[x][j] == 'p') {
                ans++;
                break;
            }
            if (board[x][j] == 'B') {
                break;
            }
        }
        return ans;
    }
}