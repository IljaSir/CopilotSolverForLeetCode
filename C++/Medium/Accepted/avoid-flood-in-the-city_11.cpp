class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        
        vector<int> ans(rains.size(), 1);
        map<int, int> lastRains;
        set<int> dryLakes;
        for (int i = 0; i < rains.size(); i++) {
            if (rains[i] == 0) {
                dryLakes.insert(i);
            } else {
                if (lastRains.find(rains[i]) != lastRains.end()) {
                    auto it = dryLakes.lower_bound(lastRains[rains[i]]);
                    if (it == dryLakes.end()) return vector<int>();
                    ans[*it] = rains[i];
                    dryLakes.erase(it);
                }
                lastRains[rains[i]] = i;
                ans[i] = -1;
            }
        }
        return ans;
    }
};