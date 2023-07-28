class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        unordered_set<string> cities;
        for (auto& p : paths) {
            cities.insert(p[0]);
        }
        for (auto& p : paths) {
            if (cities.find(p[1]) == cities.end()) {
                return p[1];
            }
        }
        return "";
    }
};