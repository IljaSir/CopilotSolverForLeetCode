class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        if (grid[0][0]) return -1;
        int n = grid.size();
        if (n == 1) return 1;
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        queue<pair<int, int>> q;
        q.push({0,0});
        grid[0][0] = 1;
        int step = 1;
        while (!q.empty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [x, y] = q.front(); q.pop();
                for (auto [dx, dy] : dirs) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny]) continue;
                    if (nx == n - 1 && ny == n - 1) return step;
                    grid[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
        }
        return -1;
    }
};