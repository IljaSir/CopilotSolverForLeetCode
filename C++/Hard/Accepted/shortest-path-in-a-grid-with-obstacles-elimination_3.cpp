class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, INT_MAX));
        queue<vector<int>> q;
        q.push({0, 0, 0});
        visited[0][0] = 0;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto cur = q.front();
                q.pop();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                vector<vector<int>> dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
                for (auto dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    int obs = cur[2] + grid[x][y];
                    if (obs < visited[x][y]) {
                        visited[x][y] = obs;
                        if (obs <= k) {
                            q.push({x, y, obs});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
};