class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        
        vector<int> result(k, 0);
        unordered_map<int, unordered_set<int>> umap;
        for (auto& log : logs) {
            umap[log[0]].insert(log[1]);
        }
        for (auto& kv : umap) {
            result[kv.second.size() - 1]++;
        }
        return result;
    }
};