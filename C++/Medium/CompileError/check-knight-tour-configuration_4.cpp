class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int moves[8][2] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        bool visited[7][7] = {false};
        int row = 0, col = 0;
        for (int i = 0; i < n * n; i++) {
            visited[row][col] = true;
            int nextRow = row, nextCol = col;
            for (int j = 0; j < 8; j++) {
                int r = row + moves[j][0];
                int c = col + moves[j][1];
                if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == i + 1) {
                    nextRow = r;
                    nextCol = c;
                    break;
                }
            }
            row = nextRow;
            col = nextCol;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    bool checkValidKnightTour(vector<vector<int>>& grid) {
        if (!checkValidGrid(grid)) {
            return false;
        }
        int n = grid.size();
        int moves[8][2] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int row = 0, col = 0;
        for (int i = 0; i < n * n; i++) {
            int nextRow = row, nextCol = col;
            for (int j = 0; j < 8; j++) {
                int r = row + moves[j][0];
                int c = col + moves[j][1];
                if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == i + 1) {
                    next
    }
};