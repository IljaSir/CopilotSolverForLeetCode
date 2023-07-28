class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        unordered_map<string, int> m;
        for (auto& p : paths) {
            m[p[0]]++;
            m[p[1]]--;
        }
        for (auto& p : m) {
            if (p.second == -1) return p.first;
        }
        return "";
    }
};