class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        unordered_map<string, int> mp;
        vector<vector<string>> ans;
        for (auto& path : paths) {
            string key = "/";
            for (auto& p : path) {
                key += p + "/";
            }
            mp[key] = 1;
        }
        for (auto& path : paths) {
            string key = "/";
            for (auto& p : path) {
                key += p + "/";
                if (mp[key] == 1) {
                    ans.push_back(path);
                    break;
                }
            }
        }
        return ans;
    }
};