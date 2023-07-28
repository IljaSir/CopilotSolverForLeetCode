class Solution {
public:
    vector<vector<int>> outerTrees(vector<vector<int>>& trees) {
        
        int n = trees.size();
        vector<vector<int>> res;
        if (n < 4) {
            return trees;
        }
        sort(trees.begin(), trees.end());
        vector<vector<int>> up;
        vector<vector<int>> down;
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
        for (int i = down.size() - 2; i > 0; --i) {
            res.push_back(down[i]);
        }
        return res;
    }
};