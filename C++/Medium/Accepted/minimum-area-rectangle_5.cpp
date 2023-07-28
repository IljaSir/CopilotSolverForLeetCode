class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        int n = points.size();
        map<int, set<int>> mp;
        for (auto& p: points) {
            mp[p[0]].insert(p[1]);
        }
        int res = INT_MAX;
        for (auto it1 = mp.begin(); it1 != mp.end(); ++it1) {
            for (auto it2 = next(it1); it2 != mp.end(); ++it2) {
                vector<int> y;
                set_intersection(it1->second.begin(), it1->second.end(), it2->second.begin(), it2->second.end(), back_inserter(y));
                for (int i = 1; i < y.size(); ++i) {
                    res = min(res, (it2->first - it1->first) * (y[i] - y[i - 1]));
                }
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};