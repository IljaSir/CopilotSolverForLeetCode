class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        
        vector<int> result(k, 0);
        unordered_map<int, unordered_set<int>> map;
        for (auto log : logs) {
            map[log[0]].insert(log[1]);
        }
        for (auto m : map) {
            result[m.second.size() - 1]++;
        }
        return result;
    }
};