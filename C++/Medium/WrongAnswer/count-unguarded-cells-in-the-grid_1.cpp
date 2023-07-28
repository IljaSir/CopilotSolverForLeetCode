class Solution {
public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        
        vector<vector<bool>> occupied(m, vector<bool>(n, false));
        for (auto& g : guards) {
            occupied[g[0]][g[1]] = true;
        }
        for (auto& w : walls) {
            occupied[w[0]][w[1]] = true;
        }
        vector<vector<bool>> seen(m, vector<bool>(n, false));
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        for (auto& g : guards) {
            queue<pair<int, int>> q;
            q.push({g[0], g[1]});
            while (!q.empty()) {
                auto [x, y] = q.front();
                q.pop();
                if (x < 0 || x >= m || y < 0 || y >= n || seen[x][y] || occupied[x][y]) {
                    continue;
                }
                seen[x][y] = true;
                for (auto& d : dirs) {
                    q.push({x + d[0], y + d[1]});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!seen[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
};