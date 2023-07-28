class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        map<int, int> m;
        for (auto& seg : segments) {
            m[seg[0]] += seg[2];
            m[seg[1]] -= seg[2];
        }
        vector<vector<long long>> res;
        int cur = 0;
        for (auto& [x, c] : m) {
            if (cur) res.push_back({res.back()[1], x, cur});
            cur += c;
        }
        return res;
    }
};