class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int a[3][3] = {0};
        int b[3][3] = {0};
        int len = moves.size();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                a[moves[i][0]][moves[i][1]] = 1;
            } else {
                b[moves[i][0]][moves[i][1]] = 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == 1 && a[i][1] == 1 && a[i][2] == 1) {
                return "A";
            }
            if (b[i][0] == 1 && b[i][1] == 1 && b[i][2] == 1) {
                return "B";
            }
            if (a[0][i] == 1 && a[1][i] == 1 && a[2][i] == 1) {
                return "A";
            }
            if (b[0][i] == 1 && b[1][i] == 1 && b[2][i] == 1) {
                return "B";
            }
        }
        if (a[0][0] == 1 && a[1][1] == 1 && a[2][2] == 1) {
            return "A";
        }
        if (a[0][2] == 1 && a[1][1] == 1 && a[2][0] == 1) {
            return "A";
        }
        if (b[0][0] == 1 && b[1][1] == 1 && b[2][2] == 1) {
            return "B";
        }
        if (b[0][2] == 1 && b[1][1] == 1 && b[2][0] == 1) {
            return "B";
        }
        if (len < 9) {
            return "Pending";
        }
        return "Draw";
    }
};