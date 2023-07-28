class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (n == 0) return 0;
        int moves = 0;
        int dir = 0;
        int r = 0, c = 0;
        while (r != n - 1 || c != n - 1) {
            if (dir == 0) {
                if (c + 1 < n && grid[r][c + 1] == 0) {
                    c++;
                } else if (r + 1 < n && grid[r + 1][c] == 0) {
                    dir = 1;
                    r++;
                } else if (c + 1 < n && r + 1 < n && grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0) {
                    dir = 2;
                    r++;
                } else {
                    return -1;
                }
            } else if (dir == 1) {
                if (r + 1 < n && grid[r + 1][c] == 0) {
                    r++;
                } else if (c + 1 < n && grid[r][c + 1] == 0) {
                    dir = 0;
                    c++;
                } else if (c + 1 < n && r + 1 < n && grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0) {
                    dir = 3;
                    c++;
                } else {
                    return -1;
                }
            } else if (dir == 2) {
                if (c + 1 < n && grid[r][c + 1] == 0) {
                    dir = 0;
                    c++;
                } else if (r + 1 < n && grid[r + 1][c] == 0) {
                    r++;
                } else {
                    return -1;
                }
            } else if (dir == 3) {
                if (r + 1 < n && grid[r + 1][c] == 0) {
                    dir = 1;
                    r++;
                } else if (c + 1 < n && grid[r][c + 1] == 0) {
                    c++;
                } else {
                    return -1;
    }
};