class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        int n = rains.size();
        vector<int> ans(n, 1);
        map<int, int> mp;
        set<int> dryDays;
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                if (mp.find(rains[i]) == mp.end()) {
                    mp[rains[i]] = i;
                } else {
                    int last = mp[rains[i]];
                    auto it = dryDays.lower_bound(last);
                    if (it == dryDays.end()) return {};
                    ans[*it] = rains[i];
                    dryDays.erase(it);
                    mp[rains[i]] = i;
                }
                ans[i] = -1;
            } else {
                dryDays.insert(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == 1) ans[i] = 1;
        }
        return ans;
    }
};