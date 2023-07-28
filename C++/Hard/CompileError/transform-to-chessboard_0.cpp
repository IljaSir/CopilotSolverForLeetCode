class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> rows(n), cols(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] = (rows[i] << 1) | board[i][j];
                cols[j] = (cols[j] << 1) | board[i][j];
            }
        }
        int rowSum = accumulate(rows.begin(), rows.end(), 0);
        int colSum = accumulate(cols.begin(), cols.end(), 0);
        if (rowSum != n / 2 * n && rowSum != (n + 1) / 2 * n) {
            return -1;
        }
        if (colSum != n / 2 * n && colSum != (n + 1) / 2 * n) {
            return -1;
        }
        if (n % 2 == 1) {
            if (rows[n / 2] % 2 == 1) {
                for (int i = 0; i < n; ++i) {
                    rows[i] ^= 1 << n / 2;
                }
            }
            if (cols[n / 2] % 2 == 1) {
                for (int i = 0; i < n; ++i) {
                    cols[i] ^= 1 << n / 2;
                }
            }
        }
        int rowSwap = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (rows[i] % 2 == 1) {
                    rowSwap += 1;
                }
            } else {
                if (rows[i] % 2 == 0) {
                    rowSwap += 1;
                }
            }
        }
        int colSwap = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (cols[i] % 2 == 1) {
                    colSwap += 1;
                }
            } else {
                if (cols[i] % 2 == 0) {
                    colSwap += 1;
                }
            }
        }
        if (n %
    }
};