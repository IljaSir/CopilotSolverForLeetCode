class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        
        int x, y;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int count = 0;
        int i = x;
        while (i >= 0) {
            if (board[i][y] == 'B') {
                break;
            }
            if (board[i][y] == 'p') {
                count++;
                break;
            }
            i--;
        }
        i = x;
        while (i < 8) {
            if (board[i][y] == 'B') {
                break;
            }
            if (board[i][y] == 'p') {
                count++;
                break;
            }
            i++;
        }
        i = y;
        while (i >= 0) {
            if (board[x][i] == 'B') {
                break;
            }
            if (board[x][i] == 'p') {
                count++;
                break;
            }
            i--;
        }
        i = y;
        while (i < 8) {
            if (board[x][i] == 'B') {
                break;
            }
            if (board[x][i] == 'p') {
                count++;
                break;
            }
            i++;
        }
        return count;
    }
};