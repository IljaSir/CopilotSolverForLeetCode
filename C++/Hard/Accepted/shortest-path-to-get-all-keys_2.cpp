class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int si, sj;
        int k = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '@') {
                    si = i;
                    sj = j;
                } else if (grid[i][j] >= 'a' && grid[i][j] <= 'f') {
                    ++k;
                }
            }
        }
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(1 << k)));
        queue<vector<int>> q;
        q.push({si, sj, 0});
        visited[si][sj][0] = 1;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                vector<int> cur = q.front();
                q.pop();
                if (cur[2] == (1 << k) - 1) {
                    return step;
                }
                for (auto& dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#') {
                        continue;
                    }
                    int status = cur[2];
                    if (grid[x][y] >= 'a' && grid[x][y] <= 'f') {
                        status |= (1 << (grid[x][y] - 'a'));
                    }
                    if (grid[x][y] >= 'A' && grid[x][y] <= 'F' && !(status & (1 << (grid[x][y] - 'A')))) {
                        continue;
                    }
                    if (!visited[x][y][status]) {
                        visited[x][y][status] = 1;
                        q.push({x, y, status});
                    }
                }
            }
            ++step;
        }
        return -1;
    }
};