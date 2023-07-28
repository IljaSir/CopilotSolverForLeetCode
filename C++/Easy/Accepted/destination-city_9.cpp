class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        map<string, int> m;
        for (auto& p : paths) {
            m[p[0]]++;
            m[p[1]]--;
        }
        for (auto& [k, v] : m) {
            if (v == -1) {
                return k;
            }
        }
        return "";
    }
};