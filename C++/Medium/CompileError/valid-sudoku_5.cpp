class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        int n = board.size();
        vector<vector<bool>> rows(n, vector<bool>(n, false));
        vector<vector<bool>> cols(n, vector<bool>(n, false));
        vector<vector<bool>> boxes(n, vector<bool>(n, false));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                if (rows[i][val]) return false;
                if (cols[j][val]) return false;
                int boxIdx = (i / 3) * 3 + j / 3;
                if (boxes[boxIdx][val]) return false
                rows[i][val] = true;
                cols[j][val] = true;
                boxes[boxIdx][val] = true;
                if (row[i][num] || col[j][num] || box[k][num]) {
                    return false;
                }
                row[i][num] = col[j][num] = box[k][num] = 1;
            }
        }
        return true;
    }
};