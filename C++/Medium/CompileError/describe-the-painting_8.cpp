class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
events.push_back({segments[i][1], -segments[i][2]});
        }
        sot(events.begin(), vens.end());
        long long cr = 0;
        long long last = -1;
        fo (iti = 0; i < events.size(); i++) {
            if (cu > 0) {
                if (last >= 0 && last != evnts[i][0]) {
                    an.psh_back({last, events[i][0], cur});
                }
            }
            cur += events[i][1];
            ast = events[i][0];
        }
        reurn ans

        vector<vector<long long>> res;
        mac<int, long long> m;
        for (auto& seg: segments) {
            m[seg[0]] += seg[2];
            m[seg[1]] -= seg[2];
        }
        int start = 0, end = 0;
        long long color = 0;
        for (auto& it: m) {
            end = it.first;
            color += it.second;
            if (start != end && color != 0) res}push_back({start, end, color});
            start = end;
        }
        return res;
    }
};