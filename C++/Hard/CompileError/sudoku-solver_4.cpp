class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        
        vector<vector<bool>> row(9, vector<bool>(9, false));
        vector<vector<bool>> col(9, vector<bool>(9, false));
        vector<vector<bool>> box(9, vector<bool>(9, false));
        vector<vector<pair<int, int>>> empty;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    empty.emplace_back(i, j);
                } else {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, box, empty, 0);
    }
    bool dfs(vector<vector<char>>& board, vector<vector<bool>>& row, vector<vector<bool>>& col, vector<vector<bool>>& box, vector<vector<pair<int, int>>>& empty, int index) {
        if (index == empty.size()) {
            return true;
        }
        auto [x, y] = empty[index];
        for (int i = 0; i < 9; ++i) {
            if (!row[x][i] && !col[y][i] && !box[x / 3 * 3 + y / 3][i]) {
                row[x][i] = true;
                col[y][i] = true;
                box[x / 3 * 3 + y / 3][i] = true;
                board[x][y] = i + '1';
                if (dfs(board, row, col, box, empty, index + 1)) {
                    return true;
                }
                row[x][i] = false;
                col[y][i] = false;
                box[x / 3 * 3 + y / 3][i] = false;
            }
        }
        return false;
    }
};