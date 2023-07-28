class Solution {
public:
    int cutOffTree(vector<vector<int>>& forest) {
        
        int m = forest.size();
        int n = m ? forest[0].size() : 0;
        vector<vector<int>> trees;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest[i][j] > 1) {
                    trees.push_back({forest[i][j], i, j});
                }
            }
        }
        sort(trees.begin(), trees.end());
        int sx = 0, sy = 0, ans = 0;
        for (auto& t : trees) {
            int d = bfs(forest, sx, sy, t[1], t[2]);
            if (d < 0) return -1;
            ans += d;
            sx = t[1], sy = t[2];
        }
        return ans;
    }

    int bfs(vector<vector<int>>& forest, int sx, int sy, int tx, int ty) {
        int m = forest.size();
        int n = m ? forest[0].size() : 0;
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue<vector<int>> q;
        vector<vector<bool>> visited(m, vector<bool>(n));
        q.push({sx, sy, 0});
        visited[sx][sy] = true;
        while (!q.empty()) {
            auto t = q.front();
            q.pop();
            if (t[0] == tx && t[1] == ty) return t[2];
            for (auto& dir : dirs) {
                int x = t[0] + dir[0];
                int y = t[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && forest[x][y]) {
                    visited[x][y] = true;
                    q.push({x, y, t[2] + 1});
                }
            }
        }
        return -1;
    }
};