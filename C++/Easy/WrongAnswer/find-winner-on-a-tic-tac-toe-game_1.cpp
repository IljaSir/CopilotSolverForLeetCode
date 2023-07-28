class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        vector<vector<int>> grid(3, vector<int>(3, 0));
        for (int i = 0; i < moves.size(); i++) {
            if (i % 2 == 0) {
                grid[moves[i][0]][moves[i][1]] = 1;
            }
            else {
                grid[moves[i][0]][moves[i][1]] = 2;
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = grid[i][0] + grid[i][1] + grid[i][2];
            if (sum == 3) {
                return "A";
            }
            else if (sum == 6) {
                return "B";
            }
            sum = grid[0][i] + grid[1][i] + grid[2][i];
            if (sum == 3) {
                return "A";
            }
            else if (sum == 6) {
                return "B";
            }
        }
        sum = grid[0][0] + grid[1][1] + grid[2][2];
        if (sum == 3) {
            return "A";
        }
        else if (sum == 6) {
            return "B";
        }
        sum = grid[0][2] + grid[1][1] + grid[2][0];
        if (sum == 3) {
            return "A";
        }
        else if (sum == 6) {
            return "B";
        }
        if (moves.size() == 9) {
            return "Draw";
        }
        else {
            return "Pending";
        }
    }
};