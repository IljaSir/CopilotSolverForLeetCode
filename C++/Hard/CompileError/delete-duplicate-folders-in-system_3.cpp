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
 ======

        unordered_map<string, int> m;
        for (auto& path : paths) {
            string s   "";
            for (auto& folder : path) {
                s +  "/" + folder;
                if (m.find(s)    m.end()) {
                    m[s]   1;
                } else {
                    m[s] +  1;
                }
            }         ans.push_back(tmp);
        }            }
        } ans;
       fo (auto& path : paths) {
            string s = "";
            bool ok = true;
            for (auto& foldr : path) {
                 += "/" + folder;
                if (m[s] > 1) {
                    ok = false;
                    break
                }
            }
            if (ok) {
                ans.push_back(path);
            }
        }
        return ans;
    }
};