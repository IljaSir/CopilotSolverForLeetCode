class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int n = moves.size();
        vector<vector<int>> g(3, vector<int>(3, 0));
        for (int i = 0; i < n; ++i) {
            g[moves[i][0]][moves[i][1]] = i % 2 ? 2 : 1;
        }
        for (int i = 0; i < 3; ++i) {
            if (g[i][0] == g[i][1] && g[i][1] == g[i][2] && g[i][0]) {
                return g[i][0] == 1 ? "A" : "B";
            }
            if (g[0][i] == g[1][i] && g[1][i] == g[2][i] && g[0][i]) {
                return g[0][i] == 1 ? "A" : "B";
            }
        }
        if (g[0][0] == g[1][1] && g[1][1] == g[2][2] && g[0][0]) {
            return g[0][0] == 1 ? "A" : "B";
        }
        if (g[0][2] == g[1][1] && g[1][1] == g[2][0] && g[0][2]) {
            return g[0][2] == 1 ? "A" : "B";
        }
        return n == 9 ? "Draw" : "Pending";
    }
};