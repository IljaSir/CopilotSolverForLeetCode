class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int N = grid.size();
        int M = grid[0].size();
        int move[8][2] = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        int row = 0, col = 0, count = 0;
        while (count < N*M) {
            int next_row = row + move[grid[row][col]][0];
            int next_col = col + move[grid[row][col]][1];
            if (next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) {
                return false;
            }
            row = next_row;
            col = next_col;
            count++;
        }
        return true;
    }
    bool isValid(int row, int col, vector<vector<int>>& grid) {
        int N = grid.size();
        int M = grid[0].size();
        return row >= 0 && row < N && col >= 0 && col < M;
    }
    bool checkValidGrid2(vector<vector<int>>& grid) {
        int N = grid.size();
        int M = grid[0].size();
        int move[8][2] = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        vector<vector<bool>> visited(N, vector<bool>(M, false));
        int row = 0, col = 0, count = 0;
        while (count < N*M) {
            if (visited[row][col]) {
                return false;
            }
            visited[row][col] = true;
            int next_row = row + move[grid[row][col]][0];
            int next_col = col + move[grid[row][col]][1];
            if (!isValid(next_row, next_col, grid)) {
                return false;
            }
            row = next_row;
            col = next_col;
            count++;
        }
        return true;
    }
};