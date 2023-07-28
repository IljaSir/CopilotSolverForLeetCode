class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        unordered_map<string, vector<vector<string>>> mp;
        for (auto &path : paths) {
            string key;
            for (auto &s : path) {
                key += "/" + s;
                mp[key].push_back(path);
            }
        }
        vector<vector<string>> ans;
        for (auto &p : mp) {
            if (p.second.size() == 1) {
                ans.push_back(p.second[0]);
            }
        }
        return ans;
    }
};