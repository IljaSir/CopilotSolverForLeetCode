class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        unordered_map<string, vector<string>> m;
        for (auto &path : paths) {
            string cur = "";
            for (auto &folder : path) {
                cur += "/" + folder;
                m[cur].push_back(path.back());
            }
        }
        unordered_set<string> dup;
        for (auto &[k, v] : m) {
            if (v.size() > 1) {
                dup.insert(k);
            }
        }
        vector<vector<string>> ans;
        for (auto &path : paths) {
            string cur = "";
            vector<string> t;
            for (auto &folder : path) {
                cur += "/" + folder;
                if (dup.find(cur) == dup.end()) {
                    t.push_back(folder);
                }
            }
            if (!t.empty()) {
                ans.push_back(t);
            }
        }
        return ans;
    }
};