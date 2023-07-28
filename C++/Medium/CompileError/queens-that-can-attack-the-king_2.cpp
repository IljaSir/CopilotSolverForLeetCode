class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        vector<vector<int>> ans;
        vector<vector<int>> board(8, vector<int>(8, 0));
        for (auto& q : queens) {
            board[q[0]][q[1]] = 1;
        }
        for (int i = king[0] - 1; i >= 0; --i) {
            if (board[i][king[1]]) {
                ans.push_back({i, king[1]});
                break;
            }
        }
        for (int i = king[0] + 1; i < 8; ++i) {
            if (board[i][king[1]]) {
                ans.push_back({i, king[1]});
                break;
            }
        }
        for (int i = king[1] - 1; i >= 0; --i) {
            if (board[king[0]][i]) {
                ans.push_back({king[0], i});
                break;
            }
        }
        for (int i = king[1] + 1; i < 8; ++i) {
            if (board[king[0]][i]) {
                ans.push_back({king[0], i});
                break;
            }
        }
        for (int i = king[0] - 1, j = king[1] - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j]) {
                ans.push_back({i, j});
                break;
            }
        }
        for (int i = king[0] + 1, j = king[1] + 1; i < 8 && j < 8; ++i, ++j) {
            if (board[i][j]) {
                ans.push_back({i, j});
                break;
            }
        }
        for (int i = king[0] - 1, j = king[1] + 1; i >= 0 && j < 8; --i, ++j) {
            if (board[i][j]) {
                ans.push_back({i, j});
                break;
            }
        }
        for (int i = king[0] + 1, j = king[1] - 1; i < 8 && j >= 0; ++i, --j) {
    }
};