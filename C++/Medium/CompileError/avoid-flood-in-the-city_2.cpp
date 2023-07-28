class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        int n = rains.size();
        vector<int> ans(n, 1);
        unordered_map<int, int> mp;
        set<int> dry;
        for (int i = 0; i < n; i++
            if (rains[i] == 0) {
                dry.insert(i);
            } else {
                if (mp.find(rains[i]) != mp.end()) {
                    auto it = dry.upper_bound(mp[rains[i]]);
                    if (it == dry.end()) {
                        return {};
                    }
                    ans[*it] = rains[i];
    dry.erse(it);
                }
                mp[rai]i;
                ans[i] = -
    }
};