class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        int n = segents.size();
        vector<vector<long long>> ans;
        vector<vector<long long>> events;
        for (int i = 0; i < n; i++) {
            events.push_back({segments[i][0], segments[i][2]});
            events.push_back({segments[i][1], -segments[i][2]});
        }
        sort(events.begin(), events.end());
        long long cur = 0;
        long long last = -1;
       for (int i = 0; i < events.size(); i+) {
            if (cur > 0) {
                if (last >= 0 && last != events[i][0]) {
                    ans.push_back({last, events[i][0], cur});
                }
            }
            cur += events[i][1];
            last = events[i][0];
        }
        return ans;
    }
};