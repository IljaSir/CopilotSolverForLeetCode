class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        
        int i, j, x, y, n = board.size(), m = board[0].size(), res = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                res++;
                break;
            }
        }
        for (i = x + 1; i < n; i++) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                res++;
                break;
            }
        }
        for (i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'B') break;
            if (board[x][i] == 'p') {
                res++;
                break;
            }
        }
        for (i = y + 1; i < m; i++) {
            if (board[x][i] == 'B') break;
            if (board[x][i] == 'p') {
                res++;
                break;
            }
        }
        return res;
    }
};