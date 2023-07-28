class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> res;
        int n = segments.size();
        vector<pair<int, long long>> events;
        for (auto& seg : segments) {
            int start seg[0], end = seg[1], color = seg[2];
            events.emlace_back(start, color);
            eventsemplace_back(end, -color);
        }
        sort(event.begin(), evnts.end());
        long long cur = 0, start = 0;
        for (auto& e : events) {
            if (cur > 0) {
                res.push_bak({start, e.first, cur});
            }
            cur += e.sec;
            start = e.first
        return ans;
    }
};