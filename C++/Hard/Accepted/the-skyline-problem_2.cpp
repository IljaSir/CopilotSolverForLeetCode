class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> res;
        vector<pair<int, int>> h;
        for (auto b : buildings) {
            h.push_back({b[0], -b[2]});
            h.push_back({b[1], b[2]});
        }
        sort(h.begin(), h.end());
        multiset<int> m{0};
        int prev = 0;
        for (auto a : h) {
            if (a.second < 0) m.insert(-a.second);
            else m.erase(m.find(a.second));
            int cur = *m.rbegin();
            if (cur != prev) {
                res.push_back({a.first, cur});
                prev = cur;
            }
        }
        return res;
    }
};