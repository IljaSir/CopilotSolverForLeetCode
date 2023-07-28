class Solution {
public:
    int cutOffTree(vector<vector<int>>& forest) {
        
        int n = forest.size();
        if (n == 0) return 0;
        int m = forest[0].size();
        if (m == 0) return 0;
        vector<pair<int, pair<int, int>>> trees;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (forest[i][j] > 1) {
                    trees.push_back({forest[i][j], {i, j}});
                }
            }
        }
        sort(trees.begin(), trees.end());
        int steps = 0;
        int x = 0, y = 0;
        for (auto t : trees) {
            int dist = bfs(forest, x, y, t.second.first, t.second.second);
            if (dist < 0) return -1;
            steps += dist;
            x = t.second.first;
            y = t.second.second;
        }
        return steps;
    }
    
    int bfs(vector<vector<int>>& forest, int x, int y, int tx, int ty) {
        int n = forest.size();
        int m = forest[0].size();
        vector<vector<int>> visited(n, vector<int>(m, 0));
        queue<pair<int, int>> q;
        q.push({x, y});
        visited[x][y] = 1;
        int steps = 0;
        while (q.empty() == false) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto p = q.front();
                q.pop();
                if (p.first == tx && p.second == ty) return steps;
                if (p.first > 0 && forest[p.first - 1][p.second] > 0 && visited[p.first - 1][p.second] == 0) {
                    q.push({p.first - 1, p.second});
                    visited[p.first - 1][p.second] = 1;
                }
                if (p.first < n - 1 && forest[p.first + 1][p.second] > 0 && visited[p.first + 1][p.second] == 0) {
                    q.push({p.first + 1, p.second});
                    visited[p.first + 1][p.second
    }
};