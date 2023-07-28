class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int n = moves.size();
        if (n < 5) return "Pending";
        int a[3][3] = {0};
        for (int i = 0; i < n; ++i) {
            a[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 1 : 2;
        }
        for (int i = 0; i < 3; ++i) {
            if (a[i][0] && a[i][0] == a[i][1] && a[i][1] == a[i][2]) {
                return a[i][0] == 1 ? "A" : "B";
            }
            if (a[0][i] && a[0][i] == a[1][i] && a[1][i] == a[2][i]) {
                return a[0][i] == 1 ? "A" : "B";
            }
        }
        if (a[0][0] && a[0][0] == a[1][1] && a[1][1] == a[2][2]) {
            return a[0][0] == 1 ? "A" : "B";
        }
        if (a[0][2] && a[0][2] == a[1][1] && a[1][1] == a[2][0]) {
            return a[0][2] == 1 ? "A" : "B";
        }
        return n == 9 ? "Draw" : "Pending";
    }
};