class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size();
        int n = isInfected[0].size();
        int ans = 0;
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (true) {
            int maxWalls = 0;
            int maxRegion = 0;
            vector<vector<int>> walls(m, vector<int>(n, 0));
            vector<vector<int>> visited(m, vector<int>(n, 0));
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        queue<vector<int>> q;
                        q.push({i, j});
                        visited[i][j] = 1;
                        int region = 0;
                        int walls = 0;
                        while (!q.empty()) {
                            auto cur = q.front();
                            q.pop();
                            ++region;
                            for (auto d : dir) {
                                int x = cur[0] + d[0];
                                int y = cur[1] + d[1];
                                if (x < 0 || x >= m || y < 0 || y >= n) {
                                    ++walls;
                                    continue;
                                }
                                if (isInfected[x][y] == 0) {
                                    ++walls;
                                    continue;
                                }
                                if (visited[x][y]) {
                                    continue;
                                }
                                q.push({x, y});
                                visited[x][y] = 1;
                            }
                        }
                        if (region > maxRegion) {
                            maxRegion = region;
                            maxWalls = walls;
                            walls = vector<vector<int>>(m, vector<int>(n, 0));
                            for (int i = 0; i < m; ++i) {
                                for (int j = 0; j < n; ++j) {
                                    if (visited[i][j] && isInfected[i][j] == 0) {
                                        walls[i][j] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (maxRegion == 0) {
                break;
            }
            ans += maxWalls;
            for (
    }
};