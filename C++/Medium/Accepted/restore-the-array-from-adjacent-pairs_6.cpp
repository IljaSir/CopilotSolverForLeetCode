class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        unordered_map<int, vector<int>> map;
        for (auto& p : adjacentPairs) {
            map[p[0]].push_back(p[1]);
            map[p[1]].push_back(p[0]);
        }
        int n = adjacentPairs.size() + 1;
        vector<int> res(n);
        for (auto& p : map) {
            if (p.second.size() == 1) {
                res[0] = p.first;
                break;
            }
        }
        res[1] = map[res[0]][0];
        for (int i = 2; i < n; ++i) {
            auto& adj = map[res[i - 1]];
            res[i] = res[i - 2] == adj[0] ? adj[1] : adj[0];
        }
        return res;
    }
};