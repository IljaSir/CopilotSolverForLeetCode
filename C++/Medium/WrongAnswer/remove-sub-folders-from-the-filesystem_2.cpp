class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        vector<string> ans;
        sort(folder.begin(), folder.end());
        for (int i = 0; i < folder.size(); i++) {
            if (i == 0 || folder[i].find(folder[i - 1] + "/") != 0) {
                ans.push_back(folder[i]);
            }
        }
        return ans;
    }
};