class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size(), n = isInfected[0].size();
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (true) {
            vector<vector<int>> walls(m, vector<int>(n, 0));
            vector<vector<bool>> visited(m, vector<bool>(n, false));
            vector<int> area;
            int cnt = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        int a = 0;
                        queue<pair<int, int>> q;
                        q.push({i, j});
                        visited[i][j] = true;
                        while (!q.empty()) {
                            auto [x, y] = q.front();
                            q.pop();
                            ++a;
                            for (auto& dir : dirs) {
                                int nx = x + dir[0], ny = y + dir[1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 0) {
                                        ++walls[nx][ny];
                                        cnt = max(cnt, walls[nx][ny]);
                                    } else if (isInfected[nx][ny] == 1 && !visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        q.push({nx, ny});
                                    }
                                }
                            }
                        }
                        area.push_back(a);
                    }
                }
            }
            if (cnt == 0) break;
            res += cnt;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (walls[i][j] == cnt) {
                        isInfected[i][j] = -1;
                    }
                }
            }
        }
        return res;
    }
};