class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        unordered_map<string, string> m;
        for (auto& path : paths) {
            m[path[0]] = path[1];
        }
        string s = paths[0][0];
        while (m.find(s) != m.end()) {
            s = m[s];
        }
        return s;
    }
};