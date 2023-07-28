class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        vector<vector<string>> res;
        unordered_map<string, int> mp;
        for (auto& path : paths) {
            string cur = "";
            for (auto& p : path) {
                cur += "/" + p;
                mp[cur]++;
            }
        }
        for (auto& path : paths) {
            string cur = "";
            bool flag = true;
            for (auto& p : path) {
                cur += "/" + p;
                if (mp[cur] > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.push_back(path);
            }
        }
        return res;
    }
};