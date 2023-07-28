class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> parent(n * n, -1);
        vector<int> size(n * n, 0);
        int maxSize = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int id = i * n + j;
                    parent[id] = id;
                    size[id] = 1;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        unionSet(id, (i - 1) * n + j, parent, size);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        unionSet(id, i * n + j - 1, parent, size);
                    }
                    maxSize = max(maxSize, size[find(id, parent)]);
                }
            }
        }
        int res = maxSize;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int id = i * n + j;
                    set<int> s;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        s.insert(find((i - 1) * n + j, parent));
                    }
                    if (i < n - 1 && grid[i + 1][j] == 1) {
                        s.insert(find((i + 1) * n + j, parent));
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        s.insert(find(i * n + j - 1, parent));
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        s.insert(find(i * n + j + 1, parent));
                    }
                    int newSize = 1;
                    for (auto it = s.begin(); it != s.end(); ++it) {
                        newSize += size[*it];
                    }
                    res = max(res, newSize);
                }
            }
        }
        return res;
    }
};