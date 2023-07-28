class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        int n = indices.size();
        vector<pair<int, pair<string, string>>> v;
        for (int i = 0; i < n; ++i) {
            v.push_back({indices[i], {sources[i], targets[i]}});
        }
        sort(v.begin(), v.end());
        string res;
        int i = 0;
        for (auto p : v) {
            int pos = p.first;
            string src = p.second.first;
            string tgt = p.second.second;
            res += s.substr(i, pos - i);
            if (s.substr(pos, src.size()) == src) {
                res += tgt;
                i = pos + src.size();
            } else {
                i = pos;
            }
        }
        res += s.substr(i, s.size() - i);
        return res;
    }
};