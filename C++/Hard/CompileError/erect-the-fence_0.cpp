class Solution {
public:
    vector<vector<int>> outerTrees(vector<vector<int>>& trees) {
        
        int n = trees.size();
        if (n < 4) return trees;
        sort(trees.begin(), trees.end(), [](auto &a, auto &b) {
            return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
        });
        vector<vector<int>> hull;
        for (int i = 0; i < n; ++i) {
            while (hull.size() >= 2 && cross(hull[hull.size() - 2], hull.back(), trees[i]) < 0) {
                hull.pop_back();
            }
            hull.push_back(trees[i]);
        }
        for (int i = n - 2; i >= 0; --i) {
            while (hull.size() >= 2 && cross(hull[hull.size() - 2], hull.back(), trees[i]) < 0) {
                hull.pop_back();
            }
            hull.push_back(trees[i]);
        }
        hull.pop_back();
        sort(hull.begin(), hull.end());
        hull.erase(unique(hull.begin(), hull.end()), hull.end());
        return hull;
    }
};