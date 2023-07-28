class Solution {
public:
    vector<vector<int>> outerTrees(vector<vector<int>>& trees) {
        
        int n = trees.size();
        vector<vector<int>> res;
        if (n <= 1) return trees;
        sort(trees.begin(), trees.end(), [](const vector<int>& a, const vector<int>& b) { return a[0] < b[0] || (a[0] == b[0] && a[1] < b[1]); });
        for (int i = 0; i < n; ++i) {
            while (res.size() >= 2 && cross(res[res.size() - 2], res[res.size() - 1], trees[i]) < 0) {
                res.pop_back();
            }
            res.push_back(trees[i]);
        }
        for (int i = n - 2, t = res.size() + 1; i >= 0; --i) {
            while (res.size() >= t && cross(res[res.size() - 2], res[res.size() - 1], trees[i]) < 0) {
                res.pop_back();
            }
            res.push_back(trees[i]);
        }
        res.pop_back();
        return res;
    }
};