class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int sx = 0, sy = 0, all = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '@') {
                    sx = i; sy = j;
                } else if (grid[i][j] >= 'a' && grid[i][j] <= 'f') {
                    all |= (1 << (grid[i][j] - 'a'));
                }
            }
        }
        queue<pair<int, int>> q;
        q.push({sx * n + sy, 0});
        int step = 0;
        vector<vector<int>> vis(m, vector<int>(n, 0));
        vis[sx][sy] = 1;
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto [cur, curKeys] = q.front(); q.pop();
                int x = cur / n, y = cur % n;
                if (curKeys == all) {
                    return step;
                }
                for (auto& dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '#') {
                        continue;
                    }
                    if (vis[nx][ny] & (1 << curKeys)) {
                        continue;
                    }
                    vis[nx][ny] |= (1 << curKeys);
                    int nextKeys = curKeys;
                    if (grid[nx][ny] >= 'a' && grid[nx][ny] <= 'f') {
                        nextKeys |= (1 << (grid[nx][ny] - 'a'));
                    } else if (grid[nx][ny] >= 'A' && grid[nx][ny] <= 'F') {
                        if (!(curKeys & (1 << (grid[nx][ny] - 'A')))) {
                            continue;
                        }
                    }
                    q.push({nx *
    }
};