class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        
        int r = -1, c = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) {
                break;
            }
        }
        int res = 0;
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'B') {
                break;
            }
            if (board[i][c] == 'p') {
                res++;
                break;
            }
        }
        for (int i = r + 1; i < 8; i++) {
            if (board[i][c] == 'B') {
                break;
            }
            if (board[i][c] == 'p') {
                res++;
                break;
            }
        }
        for (int j = c - 1; j >= 0; j--) {
            if (board[r][j] == 'B') {
                break;
            }
            if (board[r][j] == 'p') {
                res++;
                break;
            }
        }
        for (int j = c + 1; j < 8; j++) {
            if (board[r][j] == 'B') {
                break;
            }
            if (board[r][j] == 'p') {
                res++;
                break;
            }
        }
        return res;
    }
};