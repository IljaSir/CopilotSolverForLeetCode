class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        unordered_map<int, vector<int>> graph;
        for (auto& pair: adjacentPairs) {
            graph[pair[0]].push_back(pair[1]);
            graph[pair[1]].push_back(pair[0]);
        }
        vector<int> res;
        for (auto& [key, value]: graph) {
            if (value.size() == 1) {
                res.push_back(key);
                break;
            }
        }
        int pre = res[0];
        while (res.size() < adjacentPairs.size() + 1) {
            for (auto& next: graph[pre]) {
                if (res.size() == 1 || next != res[res.size() - 2]) {
                    res.push_back(next);
                    pre = next;
                    break;
                }
            }
        }
        return res;
    }
};