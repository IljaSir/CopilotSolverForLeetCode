class Solution {
public:
    int cutOffTree(vector<vector<int>>& forest) {
        
        int m = forest.size(), n = forest[0].size();
        vector<vector<int>> trees;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (forest[i][j] > 1)
                    trees.push_back({forest[i][j], i, j});
        sort(trees.begin(), trees.end());
        int x = 0, y = 0, res = 0;
        for (auto tree : trees) {
            int d = dist(forest, x, y, tree[1], tree[2]);
            if (d < 0) return -1;
            res += d;
            x = tree[1], y = tree[2];
        }
        return res;
    }
    int dist(vector<vector<int>>& forest, int sx, int sy, int tx, int ty) {
        int m = forest.size(), n = forest[0].size();
        queue<pair<int, int>> q;
        q.push({sx, sy});
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<int>> dist(m, vector<int>(n, -1));
        dist[sx][sy] = 0;
        while (!q.empty()) {
            auto t = q.front(); q.pop();
            if (t.first == tx && t.second == ty) return dist[t.first][t.second];
            for (auto dir : dirs) {
                int x = t.first + dir[0], y = t.second + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || forest[x][y] == 0 || dist[x][y] >= 0) continue;
                dist[x][y] = dist[t.first][t.second] + 1;
                q.push({x, y});
            }
        }
        return -1;
    }
};