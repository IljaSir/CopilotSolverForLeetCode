class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        
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
        int ret = 0;
        for (int i = x + 1; i < 8; ++i) {
            if (board[i][y] == 'p') {
                ret++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x - 1; i >= 0; --i) {
            if (board[i][y] == 'p') {
                ret++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = y + 1; i < 8; ++i) {
            if (board[x][i] == 'p') {
                ret++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        for (int i = y - 1; i >= 0; --i) {
            if (board[x][i] == 'p') {
                ret++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        return ret;
    }
};