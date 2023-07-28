class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        const int M = grid.size();
        const int N = grid[0].size();
        vector<vector<bool>> visited(M, vector<bool>(N, false));
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (dfs(grid, i, j, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    bool dfs(vector<vector<char>>& grid, int x, int y, int prevX, int prevY, vector<vector<bool>>& visited) {
        const int M = grid.size();
        const int N = grid[0].size();
        const int dx[4] = {0, 0, -1, 1};
        const int dy[4] = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (nx == prevX && ny == prevY) continue;
            if (grid[nx][ny] != grid[x][y]) continue;
            if (visited[nx][ny]) return true;
            visited[nx][ny] = true;
            if (dfs(grid, nx, ny, x, y, visited)) return true;
        }
        return false;
    }
};