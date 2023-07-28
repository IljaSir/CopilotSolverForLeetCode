class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        int n = paths.size();
        unordered_map<string, int> mp;
        vector<vector<string>> ans;
        for (int i = 0; i < n; i++) {
            string s = "";
            for (auto x : paths[i]) {
                s += "/" + x;
                mp[s] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            string s = "";
            bool flag = 0;
            for (auto x : paths[i]) {
                s += "/" + x;
                if (mp[s] != i) {
                    flag = 1;
                    break;
                }
            }
            if (!flag) ans.push_back(paths[i]);
        }
        return ans;
    }
};