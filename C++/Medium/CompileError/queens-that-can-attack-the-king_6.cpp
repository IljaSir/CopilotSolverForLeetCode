class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        vector<vector<int>> res;
        vector<vector<int>> board(8, vector<int>(8, 0));
        for (auto& queen: queens) {
            board[queen[0]][queen[1]] = 1;
        }
        int x = king[0];
        int y = king[1];
        int x1 = x;
        int y1 = y;
        // up
        while (x1 >= 0) {
            if (board[x1][y1] == 1) {
                res.push_back({x1, y1});
                break;
            }
            x1--;
        }
        // down
        x1 = x;
        y1 = y;
        while (x1 < 8) {
            if (board[x1][y1] == 1) {
                res.push_back({x1, y1});
                break;
            }
            x1++;
        }
        // left
        x1 = x;
        y1 = y;
        while (y1 >= 0) {
            if (board[x1][y1] == 1) {
                res.push_back({x1, y1});
                break;
            }
            y1--;
        }
        // right
        x1 = x;
        y1 = y;
        while (y1 < 8) {
            if (board[x1][y1] == 1) {
                res.push_back({x1, y1});
                break;
            }
            y1++;
        }
        // up-left
        x1 = x;
        y1 = y;
        while (x1 >= 0 && y1 >= 0) {
            if (board[x1][y1] == 1) {
                res.push_back({x1, y1});
                break;
            }
            x1--;
            y1--;
        }
        // up-right
        x1 = x;
        y1 = y;
        while (x1 >= 0 && y1 < 8) {
            if (board[x1][y1] == 1) {
                res.push_back({x1, y1});
                break;
            }
            x1--;
            y1++;
        }
        // down-left
        x1 = x;
        y1 = y;
        while (x1 < 8 && y1 >=
    }
};