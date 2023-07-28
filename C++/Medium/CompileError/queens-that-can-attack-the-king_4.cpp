class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        vector<vector<int>> res;
        vector<vector<int>> board(8, vector<int>(8, 0));
        for (auto &q : queens) {
            board[q[0]][q[1]] = 1;
        }
        int x = king[0];
        int y = king[1];
        for (int i = 1; i < 8; ++i) {
            if (x + i < 8 && y + i < 8 && board[x + i][y + i] == 1) {
                res.push_back({x + i, y + i});
                break;
            }
        }
        for (int i = 1; i < 8; ++i) {
            if (x - i >= 0 && y - i >= 0 && board[x - i][y - i] == 1) {
                res.push_back({x - i, y - i});
                break;
            }
        }
        for (int i = 1; i < 8; ++i) {
            if (x + i < 8 && y - i >= 0 && board[x + i][y - i] == 1) {
                res.push_back({x + i, y - i});
                break;
            }
        }
        for (int i = 1; i < 8; ++i) {
            if (x - i >= 0 && y + i < 8 && board[x - i][y + i] == 1) {
                res.push_back({x - i, y + i});
                break;
            }
        }
        for (int i = 1; i < 8; ++i) {
            if (x + i < 8 && board[x + i][y] == 1) {
                res.push_back({x + i, y});
                break;
            }
        }
        for (int i = 1; i < 8; ++i) {
            if (x - i >= 0 && board[x - i][y] == 1) {
                res.push_back({x - i, y});
                break;
            }
        }
        for (int i = 1; i < 8; ++i) {
            if (y + i < 8 && board[x][y + i] == 1) {
    }
};