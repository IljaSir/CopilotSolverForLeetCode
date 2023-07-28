class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int a = 0, b = 0;
        vector<int> rows(3, 0);
        vector<int> cols(3, 0);
        int diag = 0, antidiag = 0;
        for (int i = 0; i < moves.size(); ++i) {
            int r = moves[i][0], c = moves[i][1];
            if (i % 2 == 0) {
                ++rows[r];
                ++cols[c];
                if (r == c) {
                    ++diag;
                }
                if (r + c == 2) {
                    ++antidiag;
                }
            } else {
                --rows[r];
                --cols[c];
                if (r == c) {
                    --diag;
                }
                if (r + c == 2) {
                    --antidiag;
                }
            }
        }
        for (int i = 0; i < 3; ++i) {
            if (rows[i] == 3 || cols[i] == 3) {
                return "A";
            }
            if (rows[i] == -3 || cols[i] == -3) {
                return "B";
            }
        }
        if (diag == 3 || antidiag == 3) {
            return "A";
        }
        if (diag == -3 || antidiag == -3) {
            return "B";
        }
        if (moves.size() == 9) {
            return "Draw";
        }
        return "Pending";
    }
};