class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        vector<int> ans;
        int n = adjacentPairs.size();
        unordered_map<int, vector<int>> map;
        for (auto &pair : adjacentPairs) {
            map[pair[0]].push_back(pair[1]);
            map[pair[1]].push_back(pair[0]);
        }
        int start = 0;
        for (auto &p : map) {
            if (p.second.size() == 1) {
                start = p.first;
                break;
            }
        }
        ans.push_back(start);
        while (ans.size() < n + 1) {
            vector<int> &v = map[ans.back()];
            ans.push_back(v[0] == ans[ans.size() - 2] ? v[1] : v[0]);
        }
        return ans;
    }
};