class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int x = 0, y = 0;
        vector<vector<int>> visited(n, vector<int>(n, 0));
        visited[0][0] = 1;
        for (int k = 1; k < n * n; k++) {
            bool found = false;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == k) {
                    x = nx, y = ny;
                    visited[x][y] = 1;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
};