class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int N = grid.size();
        int id = 2;
        unordered_map<int, int> area;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    area[id] = dfs(grid, i, j, id);
                    id++;
                }
            }
        }
        int ans = area[2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 0) {
                    unordered_set<int> seen;
                    int cur = 1;
                    for(int k = 0; k < 4; k++) {
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if(x < 0 || x >= N || y < 0 || y >= N || grid[x][y] == 0) continue;
                        int idx = grid[x][y];
                        if(seen.count(idx)) continue;
                        seen.insert(idx);
                        cur += area[idx];
                    }
                    ans = max(ans, cur);
                }
            }
        }
        return ans;
    }
};