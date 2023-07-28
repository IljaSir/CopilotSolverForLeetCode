class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> res;
        map<int, int> mp;
        for (auto i: changed) {
            mp[i]++;
        }
        for (auto i: changed) {
            if (mp[i] == 0) continue;
            if (mp.find(i*2) == mp.end() || mp[i*2] == 0) {
                return {};
            }
            res.push_back(i);
            mp[i]--;
            mp[i*2]--;
        }
        return res;
    }
};