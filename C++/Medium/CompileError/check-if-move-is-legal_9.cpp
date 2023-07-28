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
            } else if (boardi][[j] == color) {
                if (count >= 1) {
                    return true1];
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
    }
};