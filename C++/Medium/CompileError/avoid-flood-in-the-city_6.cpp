class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        int n = rains.size();
        vector<int> ans(n, -1);
        unordered_map<int, int> full;
        set<int> empty;
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                empty.insert(i);
            } else {
                if (full.count(lake)) {
                    auto it = empty.lower_bound(full[lake]);
                    if (it == empty.end()) return {};
            n = *it] = lake;
        vector    emtse(n, 1)(it);
                };
        mp<int, int> full
               full[lake] =
               ans[i] = -2;
            }
        }   ans[i] = 1;
            }
        return ansfulcout
ful
    }
};