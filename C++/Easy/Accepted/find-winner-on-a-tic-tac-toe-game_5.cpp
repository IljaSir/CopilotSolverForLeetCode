class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int n = moves.size();
        vector<vector<int>> grid(3, vector<int>(3, 0));
        for(int i = 0; i < n; ++i) {
            int x = moves[i][0];
            int y = moves[i][1];
            if(i % 2 == 0) {
                grid[x][y] = 1;
            } else {
                grid[x][y] = 2;
            }
        }
        for(int i = 0; i < 3; ++i) {
            if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != 0) {
                return grid[i][0] == 1 ? "A" : "B";
            }
            if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != 0) {
                return grid[0][i] == 1 ? "A" : "B";
            }
        }
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != 0) {
            return grid[0][0] == 1 ? "A" : "B";
        }
        if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != 0) {
            return grid[0][2] == 1 ? "A" : "B";
        }
        return n == 9 ? "Draw" : "Pending";
    }
};