class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        int i, j, k, l;
        bool row[9][9], col[9][9], block[9][9];
        memset(row, false, sizeof(row));
        memset(col, false, sizeof(col));
        memset(block, false, sizeof(block));
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[i][num] || col[j][num] || block[i/3*3 + j/3][num]) {
                        return false;
                    }
                    row[i][num] = col[j][num] = block[i/3*3 + j/3][num] = true;
                }
            }
        }
        return true;
    }
};