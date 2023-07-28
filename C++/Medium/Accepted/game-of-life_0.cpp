class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        vector<vector<int>> tmp(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = max(0, i - 1); k < min(m, i + 2); k++) {
                    for (int l = max(0, j - 1); l < min(n, j + 2); l++) {
                        if (k == i && l == j) continue;
                        if (board[k][l] == 1) cnt++;
                    }
                }
                if (board[i][j] == 1) {
                    if (cnt == 2 || cnt == 3) tmp[i][j] = 1;
                } else {
                    if (cnt == 3) tmp[i][j] = 1;
                }
            }
        }
        board = tmp;
    }
};