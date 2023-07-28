class Solution {
public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        
        int ans = 0;
        vector<vector<bool>> guard(m, vector<bool>(n, false));
        vector<vector<bool>> wall(m, vector<bool>(n, false));
        for (auto& g : guards) {
            guard[g[0]][g[1]] = true;
        }
        for (auto& w : walls) {
            wall[w[0]][w[1]] = true;
        }
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (guard[i][j]) {
                    continue;
                }
                bool isGuard = false;
                for (auto& d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];
                    while (x >= 0 && x < m && y >= 0 && y < n) {
                        if (guard[x][y]) {
                            isGuard = true;
                            break;
                        }
                        if (wall[x][y]) {
                            break;
                        }
                        x += d[0];
                        y += d[1];
                    }
                    if (isGuard) {
                        break;
                    }
                }
                if (!isGuard) {
                    ans++;
                }
            }
        }
        return ans;
    }
};