class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        unordered_map<string, int> m;
        for (auto& path : paths) {
            string s = "";
            for (auto& folder : path) {
                s += "/" + folder;
                if (m.find(s) == m.end()) {
                    m[s] = 1;
                } else {
                    m[s] += 1;
                }
            }
        }
        vector<vector<string>> ans;
        for (auto& path : paths) {
            string s = "";
            bool ok = true;
            for (auto& folder : path) {
                s += "/" + folder;
                if (m[s] > 1) {
                    ok = false;
                    break;
                }
            }
         
        return ans;
   if (ok) {
    }
};