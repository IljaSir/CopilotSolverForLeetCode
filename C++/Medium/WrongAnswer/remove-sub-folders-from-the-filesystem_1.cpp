class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        sort(folder.begin(), folder.end());
        vector<string> res;
        for (int i = 0; i < folder.size(); i++) {
            if (i == 0 || folder[i].find(folder[i - 1] + "/") != 0) {
                res.push_back(folder[i]);
            }
        }
        return res;
    }
};