class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        int i, j, k, l;
        bool flag[10];
        for (i = 0; i < 9; ++i) {
            memset(flag, 0, sizeof(flag));
            for (j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                if (flag[board[i][j] - '0']) return false;
                flag[board[i][j] - '0'] = true;
            }
        }
        for (i = 0; i < 9; ++i) {
            memset(flag, 0, sizeof(flag));
            for (j = 0; j < 9; ++j) {
                if (board[j][i] == '.') continue;
                if (flag[board[j][i] - '0']) return false;
                flag[board[j][i] - '0'] = true;
            }
        }
        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 3; ++j) {
                memset(flag, 0, sizeof(flag));
                for (k = 0; k < 3; ++k) {
                    for (l = 0; l < 3; ++l) {
                        if (board[i * 3 + k][j * 3 + l] == '.') continue;
                        if (flag[board[i * 3 + k][j * 3 + l] - '0']) return false;
                        flag[board[i * 3 + k][j * 3 + l] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
};