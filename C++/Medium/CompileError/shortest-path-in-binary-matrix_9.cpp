class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        if (grid[0][0] == 1) return -1;
        int n = grid.size();
        if (n == 1) return 1;
        vector<vector<int>> dir = {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int path = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();
                for (auto [dx, dy]: dir) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (nx == n - 1 && ny == n - 1) return path + 1;
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == 1) continue;
                    grid[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
            path++;
        }
        return -1;
    }
};