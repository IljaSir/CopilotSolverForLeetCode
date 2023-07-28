class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        vector<vector<int>> dir = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int step = 1;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; ++i) {
                auto [x, y] = q.front();
                q.pop();
                if (x == n-1 && y == n-1) return step;
                for (auto& d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == 1) continue;
                    q.push({nx, ny});
                    grid[nx][ny] = 1;
                }
            }
            ++step;
        }
        return -1;
    }
};