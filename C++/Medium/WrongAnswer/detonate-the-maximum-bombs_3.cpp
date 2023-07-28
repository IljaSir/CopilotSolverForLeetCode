class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<vector<int>> events;
        for (auto &b : bombs) {
            events.push_back({b[0] - b[2], b[1]});
            events.push_back({b[0] + b[2], -b[1]});
        }
        sort(events.begin(), events.end());
        int res = 0, cnt = 0;
        set<int> ys;
        for (auto &e : events) {
            if (e[1] > 0) {
                if (ys.empty()) ++cnt;
                ys.insert(e[1]);
            } else {
                ys.erase(-e[1]);
                if (ys.empty()) --cnt;
            }
            res = max(res, cnt);
        }
        return res;
    }
};