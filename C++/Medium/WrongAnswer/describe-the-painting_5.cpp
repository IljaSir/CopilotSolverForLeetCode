class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> res;
        map<int, long long> m;
        for (auto& seg: segments) {
            m[seg[0]] += seg[2];
            m[seg[1]] -= seg[2];
        }
        int start = 0, end = 0;
        long long color = 0;
        for (auto& it: m) {
            end = it.first;
            color += it.second;
            if (start != end && color != 0) res.push_back({start, end, color});
            start = end;
        }
        return res;
    }
};