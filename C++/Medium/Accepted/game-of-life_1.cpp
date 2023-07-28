class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size(), n = board[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < m && l >= 0 && l < n && (k != i || l != j)) {
                            cnt += board[k][l] & 1;
                        }
                    }
                }
                if (board[i][j] == 1) {
                    if (cnt == 2 || cnt == 3) {
                        res[i][j] = 1;
                    }
                } else {
                    if (cnt == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }
        board = res;
    }
};