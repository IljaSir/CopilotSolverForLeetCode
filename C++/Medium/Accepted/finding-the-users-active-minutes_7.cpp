class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        
        vector<int> ans(k, 0);
        unordered_map<int, unordered_set<int>> uam;
        for (auto& log : logs) {
            uam[log[0]].insert(log[1]);
        }
        for (auto& [_, v] : uam) {
            ans[v.size() - 1]++;
        }
        return ans;
    }
};