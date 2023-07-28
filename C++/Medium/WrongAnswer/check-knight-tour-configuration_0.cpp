class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
        int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};
        int x = 0, y = 0;
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[x][y] = true;
        for (int i = 0; i < n * n; ++i) {
            int nx = x + dx[grid[x][y] % 8];
            int ny = y + dy[grid[x][y] % 8];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                return false;
            visited[nx][ny] = true;
            x = nx, y = ny;
        }
        return true;
    }
    bool checkValidGrid2(vector<vector<int>>& grid) {
        int n = grid.size();
        int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
        int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};
        int x = 0, y = 0;
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[x][y] = true;
        for (int i = 0; i < n * n; ++i) {
            int nx = x + dx[i % 8];
            int ny = y + dy[i % 8];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                return false;
            visited[nx][ny] = true;
            x = nx, y = ny;
        }
        return true;
    }
};