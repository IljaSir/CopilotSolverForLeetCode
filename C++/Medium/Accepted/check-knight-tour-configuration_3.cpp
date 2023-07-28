class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[0][0] = true;
        int r = 0, c = 0;
        for (int i = 0; i < n * n - 1; i++) {
            bool found = false;
            for (int k = 0; k < 8; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                if (grid[nr][nc] == i + 1) {
                    r = nr;
                    c = nc;
                    visited[r][c] = true;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
};