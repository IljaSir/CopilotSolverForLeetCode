class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        sort(folder.begin(), folder.end());
        vector<string> result;
        for (int i = 0; i < folder.size(); ++i) {
            if (i == 0 || folder[i].substr(0, folder[i - 1].size()) != folder[i - 1] || folder[i - 1][folder[i - 1].size() - 1] != '/') {
                result.push_back(folder[i]);
            }
        }
        return result;
    }
};