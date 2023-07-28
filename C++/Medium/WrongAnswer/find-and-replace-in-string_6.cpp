class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        int n = indices.size();
        vector<bool> flag(n, false);
        for (int i = 0; i < n; ++i) {
            int idx = indices[i];
            int len = sources[i].size();
            if (s.substr(idx, len) == sources[i]) {
                flag[i] = true;
            }
        }
        string ans;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            int pos = indices[i];
            ans += s.substr(idx, pos - idx);
            if (flag[i]) {
                ans += targets[i];
                idx = pos + sources[i].size();
            } else {
                idx = pos;
            }
        }
        ans += s.substr(idx);
        return ans;
    }
};