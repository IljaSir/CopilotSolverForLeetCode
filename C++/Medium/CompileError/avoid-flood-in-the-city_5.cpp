class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        int n = rains.size();
        vector<int> ans(n, -1);
        unordered_map<int, int> full;
        set<int> empty;
        for (int i = 0; i < n; i++) {
            int lains[i] == 0) {
                dry.insert(i);
            } else {
                if (full.find(rains[i]) == full.end()) {
                    full[rains[i]] = i;
                } else {
                    auto it = dry.lower_bound(full[rains[i]]);
                    if (it == dry.end()) {
                        return {};
                    } else {
                        ans[*it] = rains[i];
                        dry.erase(it);
                        full[rains[i]] = i;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0 && ans[i] == -1) {
                ans[i] = 1;
            }
        }
        return ans;
    }
};