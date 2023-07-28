class Solution {
public:
    vector<vector<int>> outerTrees(vector<vector<int>>& trees) {
        
        vector<vector<int>> res;
        if (trees.empty()) return res;
        int n = trees.size();
        if (n <= 3) return trees;
        sort(trees.begin(), trees.end());
        vector<vector<int>> up, down;
        for (int i = 0; i < n; ++i) {
            while (up.size() >= 2 && cross(up[up.size() - 2], up[up.size() - 1], trees[i]) > 0) {
                up.pop_back();
            }
            up.push_back(trees[i]);
            while (down.size() >= 2 && cross(down[down.size() - 2], down[down.size() - 1], trees[i]) < 0) {
                down.pop_back();
            }
            down.push_back(trees[i]);
        }
        for (int i = 0; i < up.size(); ++i) {
            res.push_back(up[i]);
        }
        for (int i = down.size() - 2; i >= 1; --i) {
            res.push_back(down[i]);
        }
        sort(res.begin(), res.end());
        res.erase(unique(res.begin(), res.end()), res.end());
        return res;
    }
};