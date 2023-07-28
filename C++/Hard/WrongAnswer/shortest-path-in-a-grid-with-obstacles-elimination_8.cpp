class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> dirs = {-1, 0, 1, 0, -1};
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(k + 1, 0)));
        queue<vector<int>> q;
        q.push({0, 0, 0});
        while (!q.empty()) {
            auto t = q.front();
            q.pop();
            int i = t[0], j = t[1], d = t[2];
            if (i == m - 1 && j == n - 1) {
                return d;
            }
            for (int l = 0; l < 4; ++l) {
                int x = i + dirs[l], y = j + dirs[l + 1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                int z = k - grid[x][y];
                if (z < 0 || visited[x][y][z]) {
                    continue;
                }
                visited[x][y][z] = 1;
                q.push({x, y, d + 1});
            }
        }
        return -1;
    }
};