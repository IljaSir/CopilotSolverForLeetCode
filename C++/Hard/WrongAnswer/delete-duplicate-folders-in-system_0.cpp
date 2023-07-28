class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        map<string, int> mp;
        for (int i = 0; i < paths.size(); i++) {
            string path = "";
            for (int j = 0; j < paths[i].size(); j++) {
                path += paths[i][j] + "/";
                if (mp.find(path) != mp.end()) {
                    mp[path]++;
                } else {
                    mp[path] = 1;
                }
            }
        }
        vector<vector<string>> ans;
        for (int i = 0; i < paths.size(); i++) {
            string path = "";
            vector<string> tmp;
            for (int j = 0; j < paths[i].size(); j++) {
                path += paths[i][j] + "/";
                if (mp[path] == 1) {
                    tmp.push_back(paths[i][j]);
                }
            }
            if (tmp.size() > 0) {
                ans.push_back(tmp);
            }
        }
        return ans;
    }
};