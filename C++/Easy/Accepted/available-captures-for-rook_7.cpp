class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        
        int row = board.size();
        int col = board[0].size();
        int x = 0, y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'B') {
                break;
            }
            if (board[i][y] == 'p') {
                ans++;
                break;
            }
        }
        for (int i = x + 1; i < row; i++) {
            if (board[i][y] == 'B') {
                break;
            }
            if (board[i][y] == 'p') {
                ans++;
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'B') {
                break;
            }
            if (board[x][i] == 'p') {
                ans++;
                break;
            }
        }
        for (int i = y + 1; i < col; i++) {
            if (board[x][i] == 'B') {
                break;
            }
            if (board[x][i] == 'p') {
                ans++;
                break;
            }
        }
        return ans;
    }
};