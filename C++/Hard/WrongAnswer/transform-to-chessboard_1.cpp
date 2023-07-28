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
        int r1 = rows[0], c1 = cols[0], cnt_r1 = 0, cnt_c1 = 0, cnt_r0 = 0, cnt_c0 = 0;
        for (int i = 0; i < n; ++i) {
            if (rows[i] != r1) ++cnt_r1;
            else ++cnt_r0;
            if (cols[i] != c1) ++cnt_c1;
            else ++cnt_c0;
        }
        if (abs(cnt_r1 - cnt_r0) > 1 || abs(cnt_c1 - cnt_c0) > 1) return -1;
        if (n & 1) {
            if (cnt_r1 & 1) c1 ^= (1 << (n - 1));
            if (cnt_c1 & 1) r1 ^= (1 << (n - 1));
        }
        else {
            if (cnt_r1 & 1) {
                if (cnt_c1 & 1) return -1;
                c1 ^= (1 << (n - 1));
            }
            else if (cnt_c1 & 1) r1 ^= (1 << (n - 1));
        }
        int cnt_r = 0, cnt_c = 0;
        for (int i = 0; i < n; ++i) {
            if (rows[i] != r1) {
                if ((rows[i] ^ r1) != ((1 << n) - 1)) return -1;
                ++cnt_r;
            }
            if (cols[i] != c1) {
                if ((cols[i] ^ c1) != ((1 << n) - 1)) return -1;
                ++cnt_c;
            }
        }
        return (cnt_r + cnt_c) / 2;
    }
};