class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        vector<vector<int>> res;
        vector<vector<int>> board(8, vector<int>(8, 0));
        for (auto& q : queens) {
            board[q[0]][q[1]] = 1;
        }
        int x = king[0], y = king[1];
        int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
        int dy[] = {1, -1, 0, 1, -1, 0, 1, -1};
        for (int i = 0; i < 8; ++i) {
            for (int j = 1; j < 8; ++j) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;
                if (board[nx][ny] == 1) {
                    res.push_back({nx, ny});
                    break;
                }
            }
        }
        return res;
    }
};