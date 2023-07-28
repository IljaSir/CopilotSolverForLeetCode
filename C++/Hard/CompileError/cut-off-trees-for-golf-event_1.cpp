class Solution {
public:
    int cutOffTree(vector<vector<int>>& forest) {
        
        int m = forest.size(), n = forest[0].size();
        vector<pair<int, int>> trees;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (forest[i][j] > 1) {
                    trees.emplace_back(forest[i][j], i * n + j);
                }
            }
        }
        sort(trees.begin(), trees.end());
        int ans = 0, sr = 0, sc = 0;
        for (const auto& tree : trees) {
            int tr = tree.second / n, tc = tree.second % n;
            int d = dist(forest, sr, sc, tr, tc);
            if (d < 0) {
                return -1;
            }
            ans += d;
            sr = tr;
            sc = tc;
        }
        return ans;
    }
};