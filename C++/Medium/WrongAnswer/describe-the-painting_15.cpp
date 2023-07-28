class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> res;
        int n = segments.size();
        vector<pair<int, long long>> events;
        for (auto& seg : segments) {
            int start = seg[0], end = seg[1], color = seg[2];
            events.emplace_back(start, color);
            events.emplace_back(end, -color);
        }
        sort(events.begin(), events.end());
        long long cur = 0, start = 0;
        for (auto& e : events) {
            if (cur > 0) {
                res.push_back({start, e.first, cur});
            }
            cur += e.second;
            start = e.first;
        }
        return res;
    }
};