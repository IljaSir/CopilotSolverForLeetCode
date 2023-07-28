class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        int n = rains.size();
        vector<int> ans(n, -1);
        unordered_map<int, int> full;
        set<int> dry;
        for (int i = 0; i < n; ++i) {
            if (rains[i] > 0) {
                if (full.count(rains[i]) > 0) {
                    auto it = dry.lower_bound(full[rains[i]]);
                    if (it == dry.end()) {
                        return {};
                    }
                    ans[*it] = rains[i];
                    dry.erase(it);
                }
                full[rains[i]] = i;
                ans[i] = -1;
            } else {
                dry.insert(i);
            }
        }
        for (auto x: dry) {
            ans[x] = 1;
        }
        return ans;
    }
};