class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        unordered_map<string, int> m;
        for (auto& p : paths) {
            m[p[0]]++;
            m[p[1]]++;
        }
        for (auto& p : paths) {
            if (m[p[1]] == 1)
                return p[1];
        }
        return "";
    }
};