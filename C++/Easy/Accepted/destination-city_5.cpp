class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        unordered_map<string, int> um;
        for (int i = 0; i < paths.size(); i++) {
            um[paths[i][0]] = 1;
            if (um.find(paths[i][1]) == um.end()) {
                um[paths[i][1]] = 0;
            }
        }
        for (auto& it : um) {
            if (it.second == 0) {
                return it.first;
            }
        }
        return "";
    }
};