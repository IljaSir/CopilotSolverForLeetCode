class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int n = board.size();
        int m = board[0].size();
        vector<vector<int>> tmp(n, vector<int>(m));
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int cnt = 0;
                if (i-1>=0 && j-1>=0) {
                    cnt += board[i-1][j-1];
                }
                if (i-1>=0) {
                    cnt += board[i-1][j];
                }
                if (i-1>=0 && j+1<m) {
                    cnt += board[i-1][j+1];
                }
                if (j-1>=0) {
                    cnt += board[i][j-1];
                }
                if (j+1<m) {
                    cnt += board[i][j+1];
                }
                if (i+1<n && j-1>=0) {
                    cnt += board[i+1][j-1];
                }
                if (i+1<n) {
                    cnt += board[i+1][j];
                }
                if (i+1<n && j+1<m) {
                    cnt += board[i+1][j+1];
                }
                if (board[i][j] == 1) {
                    if (cnt < 2) {
                        tmp[i][j] = 0;
                    } else if (cnt == 2 || cnt == 3) {
                        tmp[i][j] = 1;
                    } else if (cnt > 3) {
                        tmp[i][j] = 0;
                    }
                } else {
                    if (cnt == 3) {
                        tmp[i][j] = 1;
                    }
                }
            }
        }
        board = tmp;
    }
};