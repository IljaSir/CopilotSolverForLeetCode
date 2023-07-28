class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        int n = folder.size();
        if (n == 0) return {};
        if (n == 1) return folder;
        sort(folder.begin(), folder.end());
        vector<string> res;
        res.push_back(folder[0]);
        for (int i = 1; i < n; ++i) {
            string s = folder[i];
            int j = 0;
            while (j < res.size()) {
                string t = res[j];
                if (s.size() > t.size() && s.substr(0, t.size()) == t && s[t.size()] == '/') {
                    break;
                }
                ++j;
            }
            if (j == res.size()) {
                res.push_back(s);
            }
        }
        return res;
    }
};