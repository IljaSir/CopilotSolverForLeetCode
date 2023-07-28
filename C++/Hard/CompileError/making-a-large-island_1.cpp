class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> area(n*n+2, 0);
        int id = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area[id] = dfs(grid, i, j, id);
                    id++;
                }
            }
        }
        int res = *max_element(area.begin(), area.end());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    unordered_set<int> seen;
                    for (auto d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        int idx = grid[x][y];
                        if (seen.count(idx)) continue;
                        seen.insert(idx);
                        cur += area[idx];
                    }
                    res = max(res, cur);
                }
            }
        }
        return res;
    }
};