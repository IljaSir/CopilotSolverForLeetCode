class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> visited(n, vector<int>(n, 0));
        int found = 0;
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, q, i, j);
                    found = 1;
                    break;
                }
            }
            if (found) break;
        }
        int ans = 0;
        while (!q.empty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.front().first, y = q.front().second;
                q.pop();
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    if (grid[x - 1][y] == 1) return ans;
                    q.push({x - 1, y});
                    visited[x - 1][y] = 1;
                }
                if (x + 1 < n && !visited[x + 1][y]) {
                    if (grid[x + 1][y] == 1) return ans;
                    q.push({x + 1, y});
                    visited[x + 1][y] = 1;
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    if (grid[x][y - 1] == 1) return ans;
                    q.push({x, y - 1});
                    visited[x][y - 1] = 1;
                }
                if (y + 1 < n && !visited[x][y + 1]) {
                    if (grid[x][y + 1] == 1) return ans;
                    q.push({x, y + 1});
                    visited[x][y + 1] = 1;
                }
            }
            ans++;
        }
        return ans;
    }
};