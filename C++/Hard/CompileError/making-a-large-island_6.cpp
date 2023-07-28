class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> parent(n * n, -1);
        vector<int> sz(n * n, 0);
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        auto find = [&](int x) {
            if (parent[x] == -1) return x;
            return parent[x] = find(parent[x]);
        };
        auto unionSet = [&](int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (sz[px] > sz[py]) swap(px, py);
            parent[px] = py;
            sz[py] += sz[px];
        };
        auto getRoot = [&](int x) {
            while (parent[x] != -1) x = parent[x];
            return x;
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j]) continue;
                int id = i * n + j;
                sz[id] = 1;
                for (auto& dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || !grid[ni][nj]) continue;
                    unionSet(id, ni * n + nj);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) continue;
                int id = i * n + j;
                unordered_set<int> roots;
                for (auto& dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || !grid[ni][nj]) continue;
                    roots.insert(getRoot(ni * n + nj));
                }
                int cur = 1;
                for (auto& r : roots) cur += sz[r];
    }
};