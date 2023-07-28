class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        unordered_map<int, vector<int>> m;
        for (auto& p : adjacentPairs) {
            m[p[0]].push_back(p[1]);
            m[p[1]].push_back(p[0]);
        }
        int n = adjacentPairs.size();
        vector<int> res(n + 1);
        for (auto& [k, v] : m) {
            if (v.size() == 1) {
                res[0] = k;
                break;
            }
        }
        res[1] = m[res[0]][0];
        for (int i = 2; i <= n; ++i) {
            auto& v = m[res[i - 1]];
            res[i] = v[0] == res[i - 2] ? v[1] : v[0];
        }
        return res;
    }
};