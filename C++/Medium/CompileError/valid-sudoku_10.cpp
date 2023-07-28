class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        int i, j, k, l;
        bool flag[10];
        for (i = 0; i < 9; ++i) {
            memset(flag, 0, sizeof(flag))
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

        for(int i=0;i<9;i++){
            int row[10]={0};
            int col[10]={0};
            int box[10]={0};
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(row[board[i][j]-'0']) return false;
                    row[board[i][j]-'0']=1;
                }
                if(board[j][i]!='.'){
                    if(col[board[j][i]-'0']) return false;
                    col[board[j][i]-'0']=1;
                }
                int r=i/3*3+j/3;
                int c=i%3*3+j%3;
                if(board[r][c]!='.'){
                    if(box[board[r][c]-'0']) return false;
                    box[board[r][c]-'0']=1;
                }
            }
        }
        return true;
    }
};