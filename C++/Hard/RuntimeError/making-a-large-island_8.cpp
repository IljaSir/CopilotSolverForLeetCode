class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> id(n*n);
        vector<int> area(n*n);
        int curId = 2;
        int ans = 0;
        int dirs[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = curId;
                    int curArea = 1;
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    while (!q.empty()) {
                        auto [x, y] = q.front();
                        q.pop();
                        for (auto& dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (grid[nx][ny] == 1) {
                                grid[nx][ny] = curId;
                                q.push({nx, ny});
                                curArea++;
                            }
                        }
                    }
                    ans = max(ans, curArea);
                    area[curId] = curArea;
                    curId++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unordered_set<int> ids;
                    for (auto& dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        ids.insert(grid[nx][ny]);
                    }
                    int curArea = 1;
                    for (auto& id : ids) {
                        curArea += area[id];
                    }
                    ans = max(ans, curArea);
                }
            }
        }
        return ans;
    }
};