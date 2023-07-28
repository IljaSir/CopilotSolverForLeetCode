class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int n = moves.size();
        vector<int> row(3, 0), col(3, 0);
        int diag = 0, antiDiag = 0;
        int player = 1;
        for (int i = 0; i < n; i++) {
            int r = moves[i][0], c = moves[i][1];
            row[r] += player;
            col[c] += player;
            if (r == c) {
                diag += player;
            }
            if (r + c == 2) {
                antiDiag += player;
            }
            if (abs(row[r]) == 3 || abs(col[c]) == 3 || abs(diag) == 3 || abs(antiDiag) == 3) {
                return player == 1 ? "A" : "B";
            }
            player = -player;
        }
        return n == 9 ? "Draw" : "Pending";
    }
};