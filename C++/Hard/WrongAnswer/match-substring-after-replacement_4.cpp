class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        unordered_map<char, char> m;
        for (auto &v : mappings) {
            if (m.count(v[0]) && m[v[0]] != v[1]) return false;
            m[v[0]] = v[1];
        }
        int i = 0, j = 0;
        while (i < s.size() && j < sub.size()) {
            if (m.count(sub[j]) && s[i] == m[sub[j]]) {
                ++i;
                ++j;
            } else if (s[i] == sub[j]) {
                ++i;
                ++j;
            } else {
                ++i;
            }
        }
        return j == sub.size();
    }
};