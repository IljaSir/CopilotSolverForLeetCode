class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        
        int m = board.size();
        int n = board[0].size();
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            int count = 0;
            if (x > 0 && y > 0 && board[x - 1][y - 1] == 'M') {
                count++;
            }
            if (x > 0 && board[x - 1][y] == 'M') {
                count++;
            }
            if (x > 0 && y < n - 1 && board[x - 1][y + 1] == 'M') {
                count++;
            }
            if (y > 0 && board[x][y - 1] == 'M') {
                count++;
            }
            if (y < n - 1 && board[x][y + 1] == 'M') {
                count++;
            }
            if (x < m - 1 && y > 0 && board[x + 1][y - 1] == 'M') {
                count++;
            }
            if (x < m - 1 && board[x + 1][y] == 'M') {
                count++;
            }
            if (x < m - 1 && y < n - 1 && board[x + 1][y + 1] == 'M') {
                count++;
            }
            if (count == 0) {
                board[x][y] = 'B';
                if (x > 0 && y > 0 && board[x - 1][y - 1] == 'E') {
                    updateBoard(board, vector<int>{x - 1, y - 1});
                }
                if (x > 0 && board[x - 1][y] == 'E') {
                    updateBoard(board, vector<int>{x - 1, y});
                }
                if (x > 0 && y < n - 1 && board[x - 1][y + 1] == 'E') {
                    updateBoard(board, vector<int>{x - 1, y + 1});
                }
                if (y > 0 && board[x][y - 1] == 'E') {
                    update
    }
};