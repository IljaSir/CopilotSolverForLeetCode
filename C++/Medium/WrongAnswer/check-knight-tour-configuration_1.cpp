class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int dy[] = {2, 1, -1, -2, -2, -1, 1, 2};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x, y;
                for (int k = 0; k < 8; k++) {
                    x = i + dx[k];
                    y = j + dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == grid[i][j] + 1) {
                        break;
                    }
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    return false;
                }
            }
        }
        return true;
    }
    bool checkKnightTourConfiguration(vector<vector<int>>& grid) {
        int n = grid.size();
        if (n < 3 || n > 7) {
            return false;
        }
        int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int dy[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int cnt = 0;
        int x = 0, y = 0;
        int k = 0;
        while (cnt < n * n) {
            if (grid[x][y] != cnt) {
                return false;
            }
            cnt++;
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != -1) {
                k = (k + 1) % 8;
            } else {
                x = nx;
                y = ny;
            }
        }
        return checkValidGrid(grid);
    }
};