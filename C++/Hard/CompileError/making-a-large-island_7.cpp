class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> id(n, vector<int>(n, -1));
        vector<int> area;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && id[i][j] == -1) {
                    area.push_back(0);
                    dfs(grid, id, i, j, cur, area);
                    ans = max(ans, area[cur]);
                    cur++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    set<int> seen;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            if (seen.find(id[ni][nj]) == seen.end()) {
                                seen.insert(id[ni][nj]);
                                cur += area[id[ni][nj]];
                            }
                        }
                    }
                    ans = max(ans, cur);
                }
            }
        }
        return ans;
    }
};