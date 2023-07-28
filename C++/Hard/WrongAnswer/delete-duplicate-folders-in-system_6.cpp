class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        unordered_map<string, vector<string>> m;
        for (auto &p : paths) {
            string key = "";
            for (auto &s : p) {
                key += "/" + s;
                m[key].push_back(p.back());
            }
        }
        vector<vector<string>> ans;
        for (auto &p : paths) {
            string key = "";
            bool dup = false;
            for (auto &s : p) {
                key += "/" + s;
                if (m[key].size() > 1) {
                    dup = true;
                    break;
                }
            }
            if (!dup) ans.push_back(p);
        }
        return ans;
    }
};