class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size(), n = grid[0].size(), keys = 0;
        int sx, sy;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '@') {
                    sx = i;
                    sy = j;
                } else if (islower(grid[i][j])) {
                    keys++;
                }
            }
        }
        queue<tuple<int, int, int>> q;
        q.push({sx, sy, 0});
        unordered_set<string> seen;
        seen.insert(to_string(sx) + "#" + to_string(sy) + "#" + to_string(0));
        int res = 0;
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.empty()) {
            for (int i = q.size(); i > 0; --i) {
                auto [x, y, k] = q.front();
                q.pop();
                if (k == (1 << keys) - 1) {
                    return res;
                }
                for (auto& dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1], nk = k;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '#') {
                        continue;
                    }
                    if (isupper(grid[nx][ny]) && !(nk & (1 << (grid[nx][ny] - 'A')))) {
                        continue;
                    }
                    if (islower(grid[nx][ny])) {
                        nk |= 1 << (grid[nx][ny] - 'a');
                    }
                    string state = to_string(nx) + "#" + to_string(ny) + "#" + to_string(nk);
                    if (seen.count(state)) {
                        continue;
                    }
                    seen.insert(state);
                    q.push({nx, ny, nk});
                }
            }
            ++res;
        }
        return -1;
    }
};