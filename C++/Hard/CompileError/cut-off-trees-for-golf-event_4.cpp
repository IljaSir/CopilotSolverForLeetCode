class Solution {
public:
    int cutOffTree(vector<vector<int>>& forest) {
        
        int m = forest.size();
        int n = forest[0].size();
        vector<pair<int, int>> trees;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest[i][j] > 1) {
                    trees.push_back({forest[i][j], i * n + j});
                }
            }
        }
        sort(trees.begin(), trees.end());
        int steps = 0;
        int x = 0;
        int y = 0;
        for (auto& tree : trees) {
            int dist = bfs(forest, x, y, tree.second / n, tree.second % n);
            if (dist < 0) {
                return -1;
            }
            steps += dist;
            x = tree.second / n;
            y = tree.second % n;
        }
        return steps;
    }
};