class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> res;
        unordered_map<int, int> m;
        for (auto x : changed) {
            ++m[x];
        }
        sort(changed.begin(), changed.end());
        for (auto x : changed) {
            if (m[x] == 0) continue;
            if (m[x * 2] == 0) return {};
            --m[x];
            --m[x * 2];
            res.push_back(x);
        }
        return res;
    }
};