class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> res;
        vector<pair<int, int>> points;
        for (auto& b : buildings) {
            points.push_back({b[0], -b[2]});
            points.push_back({b[1], b[2]});
        }
        sort(points.begin(), points.end());
        multiset<int> mset;
        mset.insert(0);
        int prev = 0;
        for (auto& p : points) {
            if (p.second < 0) {
                mset.insert(-p.second);
            } else {
                mset.erase(mset.find(p.second));
            }
            int cur = *mset.rbegin();
            if (prev != cur) {
                res.push_back({p.first, cur});
                prev = cur;
            }
        }
        return res;
    }
};