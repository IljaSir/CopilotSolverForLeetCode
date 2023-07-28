class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dirs{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue<vector<int>> q;
        q.push({0, 0, 0});
        vector<vector<int>> visited(m, vector<int>(n, 0));
        visited[0][0] = 1;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto t = q.front();
                q.pop();
                if (t[0] == m - 1 && t[1] == n - 1) return step;
                for (auto dir : dirs) {
                    int x = t[0] + dir[0], y = t[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == 1 && t[2] + 1 <= k && !visited[x][y]) {
                            visited[x][y] = 1;
                            q.push({x, y, t[2] + 1});
                        }
                        if (grid[x][y] == 0 && !visited[x][y]) {
                            visited[x][y] = 1;
                            q.push({x, y, t[2]});
                        }
                    }
                }
            }
            ++step;
        }
        return -1;
    }
};