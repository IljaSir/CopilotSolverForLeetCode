class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        int n = indices.size();
        vector<pair<int, int>> vp;
        for (int i = 0; i < n; i++) {
            vp.push_back({indices[i], i});
        }
        sort(vp.begin(), vp.end());
        string ans;
        int i = 0;
        int m = s.size();
        while (i < m) {
            bool found = false;
            for (int j = 0; j < n; j++) {
                int idx = vp[j].first;
                int sourceIdx = vp[j].second;
                if (i == idx && s.substr(i, sources[sourceIdx].size()) == sources[sourceIdx]) {
                    ans += targets[sourceIdx];
                    i += sources[sourceIdx].size();
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans += s[i];
                i++;
            }
        }
        return ans;
    }
};