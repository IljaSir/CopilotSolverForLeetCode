class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        vector<int> area;
        area.push_back(0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int cnt = 0;
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    visited[i][j] = true;
                    while (!q.empty()) {
                        auto [r, c] = q.front(); q.pop();
                        cnt++;
                        for (auto [dr, dc]: dir) {
                            int nr = r + dr, nc = c + dc;
                            if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || grid[nr][nc] == 0) continue;
                            visited[nr][nc] = true;
                            q.push({nr, nc});
                        }
                    }
                    area.push_back(cnt);
                    res = max(res, cnt);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cnt = 1;
                    unordered_set<int> s;
                    for (auto [dr, dc]: dir) {
                        int nr = i + dr, nc = j + dc;
                        if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 0) continue;
                        if (s.find(grid[nr][nc]) == s.end()) {
                            cnt += area[grid[nr][nc]];
                            s.insert(grid[nr][nc]);
                        }
                    }
                    res = max(res, cnt);
                }
            }
        }
        return res;
    }
};