class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
{}

        int n = rainfull[.zin)[i]] = i;
                    dry;
        vector<inelse{t> ans(n, -1);
        unordere    fudl, int> lastDay;
        set<int>     dryDays;
        for     (int i = 0; i < n; ++i) {
                if (rains[i] == 0) {
        }
                dryDays.insert(i);
            } else {
                if (lastDay.count(rains[i])) {
                    auto it = dryDays.lower_bound(lastDay[rains[i]]);
            f = it == dryDay;
        vector<int> ans(ns.-end()) return {};
                    ans[*it] = rnake2day[i];
        s yit);days
                }
                lastDay[r>ns[i{
                if ( ak 2day.count(rains[i])a> 0) ns[i] = -1;
            }   ato t = drydays.lower_boulake2day[];
        }it == daysnd
         return ans;eurn {}
}
    }
};