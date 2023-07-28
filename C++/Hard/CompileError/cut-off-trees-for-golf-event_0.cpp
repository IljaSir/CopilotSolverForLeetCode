class Solution {
public:
    int cutOffTree(vector<vector<int>>& forest) {
        
        int m = forest.size(), n = forest[0].size();
        vector<vector<int>> trees;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest[i][j] > 1) {
                    trees.push_back({forest[i][j], i, j});
                }
            }
        }
        sort(trees.begin(), trees.end());
        int ans = 0;
        int x = 0, y = 0;
        for (auto& tree : trees) {
            int d = dist(forest, x, y, tree[1], tree[2]);
            if (d < 0) return -1;
            ans += d;
            x = tree[1];
            y = tree[2];
        }
        return ans;
    }
};