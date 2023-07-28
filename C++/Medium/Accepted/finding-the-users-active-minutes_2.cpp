class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        
        vector<int> ans(k, 0);
        unordered_map<int, unordered_set<int>> m;
        for (auto &log : logs) {
            m[log[0]].insert(log[1]);
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            ans[it->second.size() - 1]++;
        }
        return ans;
    }
};