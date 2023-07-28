class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> res;
        sort(changed.begin(), changed.end());
        map<int, int> m;
        for (auto i: changed) {
            m[i]++;
        }
        for (auto i: changed) {
            if (m[i] == 0) continue;
            if (m.count(i*2) == 0 || m[i*2] == 0) return {};
            res.push_back(i);
            m[i]--;
            m[i*2]--;
        }
        return res;
    }
};