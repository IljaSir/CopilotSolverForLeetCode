class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int startx, starty;
        int totalKeys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@') {
                    startx = i;
                    starty = j;
                } else if (grid[i][j] >= 'a' && grid[i][j] <= 'f') {
                    totalKeys++;
                }
            }
        }
        queue<vector<int>> q;
        q.push({startx, starty, 0});
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(1 << 6, 0)));
        visited[startx][starty][0] = 1;
        int step = 0;
        vector<int> dx = {-1, 1, 0, 0};
        vector<int> dy = {0, 0, -1, 1};
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto cur = q.front();
                q.pop();
                int x = cur[0], y = cur[1], keys = cur[2];
                if (keys == (1 << totalKeys) - 1) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '#') {
                        continue;
                    }
                    int nkeys = keys;
                    if (grid[nx][ny] >= 'a' && grid[nx][ny] <= 'f') {
                        nkeys |= (1 << (grid[nx][ny] - 'a'));
                    }
                    if (grid[nx][ny] >= 'A' && grid[nx][ny] <= 'F' && ((nkeys >> (grid[nx][ny] - 'A')) & 1) == 0) {
                        continue;
                    }
                    if (visited[nx][ny][nkeys] == 0) {
                        visited[nx][ny][nkeys
    }
};