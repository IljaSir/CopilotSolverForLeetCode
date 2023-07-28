class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dirs{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(k+1, 0)));
        queue<vector<int>> q;
        q.push({0, 0, 0});
        visited[0][0][0] = 1;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto cur = q.front();
                q.pop();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (auto dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    int obs = cur[2] + grid[x][y];
                    if (x >= 0 && x < m && y >= 0 && y < n && obs <= k && !visited[x][y][obs]) {
                        q.push({x, y, obs});
                        visited[x][y][obs] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
};