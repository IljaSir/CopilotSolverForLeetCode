class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        vector<vector<int>> result;
        vector<vector<int>> board(8, vector<int>(8, 0));
        for (auto queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }
        int x = king[0];
        int y = king[1];
        // left
        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 1) {
                result.push_back({i, y});
                break;
            }
        }
        // right
        for (int i = x; i < 8; i++) {
            if (board[i][y] == 1) {
                result.push_back({i, y});
                break;
            }
        }
        // up
        for (int i = y; i >= 0; i--) {
            if (board[x][i] == 1) {
                result.push_back({x, i});
                break;
            }
        }
        // down
        for (int i = y; i < 8; i++) {
            if (board[x][i] == 1) {
                result.push_back({x, i});
                break;
            }
        }
        // left-up
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                result.push_back({i, j});
                break;
            }
        }
        // left-down
        for (int i = x, j = y; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == 1) {
                result.push_back({i, j});
                break;
            }
        }
        // right-up
        for (int i = x, j = y; i < 8 && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                result.push_back({i, j});
                break;
            }
        }
        // right-down
        for (int i = x, j = y; i < 8 && j < 8; i++, j++) {
            if (board[i][j] == 1) {
                result.push_back({i, j});
    }
};