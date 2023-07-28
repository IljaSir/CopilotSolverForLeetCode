class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int count = 0;
        int n = board.size();
        int m = board[0].size();
        int i = rMove;
        int j = cMove;
        char other = color == 'B' ? 'W' : 'B';
        // check left
        for (j = cMove - 1; j >= 0; j--) {
            if (board[i][j] == other) {
                count++;
            } else if (board[i][j] == color) {
                if (count >= 1) {
                    return true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        count = 0;
        // check right
        for (j = cMove + 1; j < m; j++) {
            if (board[i][j] == other) {
                count++;
            } else if (board[i][j] == color) {
                if (count >= 1) {
                    return true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        count = 0;
        // check up
        for (i = rMove - 1; i >= 0; i--) {
            if (board[i][j] == other) {
                count++;
            } else if (board[i][j] == color) {
                if (count >= 1) {
                    return true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        count = 0;
        // check down
        for (i = rMove + 1; i < n; i++) {
            if (board[i][j] == other) {
                count++;
            } else if (board[i][j] == color) {
                if (count >= 1) {
                    return true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        count = 0;
        // check left up
        i = rMove;
        j = cMove;
        for (i = rMove - 1, j = cMove - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == other) {
                count++;
            } else if (board[i][j] ==
    }
};