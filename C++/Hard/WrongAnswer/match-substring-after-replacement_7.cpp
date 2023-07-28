class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        unordered_map<char, char> m;
        for (auto& v: mappings) m[v[0]] = v[1];
        for (int i = 0; i < s.size(); ++i) {
            string t = s.substr(i, sub.size());
            if (match(t, sub, m)) return true;
        }
        return false;
    }
    bool match(string s, string sub, unordered_map<char, char>& m) {
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] != sub[i]) {
                if (m.find(s[i]) == m.end()) return false;
                if (m[s[i]] != sub[i]) return false;
            }
        }
        return true;
    }
};