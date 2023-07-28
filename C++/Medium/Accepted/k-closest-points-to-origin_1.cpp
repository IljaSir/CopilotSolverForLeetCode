class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        vector<pair<int, int>> dists;
        for (int i = 0; i < points.size(); i++) {
            dists.push_back({points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        nth_element(dists.begin(), dists.begin() + k, dists.end());
        vector<vector<int>> res;
        for (int i = 0; i < k; i++) {
            res.push_back(points[dists[i].second]);
        }
        return res;
    }
};