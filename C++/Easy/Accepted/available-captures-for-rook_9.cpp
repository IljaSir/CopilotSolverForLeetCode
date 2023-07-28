class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        
        int x = 0, y = 0, i = 0, j = 0, n = board.size();
        for (i = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (j < n) {
                break;
            }
        }
        int res = 0;
        for (int k = x - 1; k >= 0; --k) {
            if (board[k][y] == 'p') {
                res++;
                break;
            } else if (board[k][y] == 'B') {
                break;
            }
        }
        for (int k = x + 1; k < n; ++k) {
            if (board[k][y] == 'p') {
                res++;
                break;
            } else if (board[k][y] == 'B') {
                break;
            }
        }
        for (int k = y - 1; k >= 0; --k) {
            if (board[x][k] == 'p') {
                res++;
                break;
            } else if (board[x][k] == 'B') {
                break;
            }
        }
        for (int k = y + 1; k < n; ++k) {
            if (board[x][k] == 'p') {
                res++;
                break;
            } else if (board[x][k] == 'B') {
                break;
            }
        }
        return res;
    }
};