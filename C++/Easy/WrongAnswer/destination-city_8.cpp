class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        unordered_map<string, int> m;
        for (auto path : paths) {
            m[path[0]]++;
            m[path[1]] = 0;
        }
        for (auto p : m) {
            if (p.second == 0) return p.first;
        }
        return "";
    }
};