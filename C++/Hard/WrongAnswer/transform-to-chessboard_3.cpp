class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> rows(n), cols(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = (rows[i] << 1) | board[i][j];
                cols[j] = (cols[j] << 1) | board[i][j];
            }
        }
        int r0 = rows[0], c0 = cols[0], cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (rows[i] ^ r0) & 1;
            cnt += (cols[i] ^ c0) & 1;
        }
        if (cnt > 2) return -1;
        if (cnt == 1 && (r0 ^ c0 ^ 1) & 1) return -1;
        int r1 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            r1 += (rows[i] ^ r0 ^ (i & 1)) & 1;
            c1 += (cols[i] ^ c0 ^ (i & 1)) & 1;
        }
        if (n & 1) {
            if (r1 & 1) r1 = n - r1;
            if (c1 & 1) c1 = n - c1;
        } else {
            r1 = min(r1, n - r1);
            c1 = min(c1, n - c1);
        }
        return (r1 + c1) / 2;
    }
};