class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        
        vector<int> result(k, 0);
        unordered_map<int, unordered_set<int>> user_map;
        for (auto log: logs)
            user_map[log[0]].insert(log[1]);
        for (auto user: user_map)
            result[user.second.size()-1]++;
        return result;
    }
};