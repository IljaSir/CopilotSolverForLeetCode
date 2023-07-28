class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        unordered_map<int, vector<int>> mp;
        for (auto& p: adjacentPairs) {
            mp[p[0]].push_back(p[1]);
            mp[p[1]].push_back(p[0]);
        }
        int start = 0;
        for (auto& [u, v]: mp) {
            if (v.size() == 1) {
                start = u;
                break;
            }
        }
        vector<int> res;
        int prev = -1;
        while (mp.count(start)) {
            res.push_back(start);
            auto& v = mp[start];
            int next = v[0];
            if (next == prev) {
                next = v[1];
            }
            prev = start;
            start = next;
        }
        return res;
    }
};