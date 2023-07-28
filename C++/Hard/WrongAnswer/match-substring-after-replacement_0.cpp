class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        int n = s.size();
        int m = sub.size();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s[i] == sub[j]) {
                ++i;
                ++j;
            } else {
                int k = 0;
                for (; k < mappings.size(); ++k) {
                    if (s[i] == mappings[k][0]) {
                        s[i] = mappings[k][1];
                        break;
                    }
                }
                if (k == mappings.size()) {
                    return false;
                }
            }
        }
        return j == m;
    }
    bool isSubsequence(string s, string t) {
        int n = s.size();
        int m = t.size();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        return i == n;
    }
    bool isMatch(string s, string p) {
        int n = s.size();
        int m = p.size();
        int i = 0;
        int j = 0;
        vector<vector<char>> mappings;
        while (i < n && j < m) {
            if (s[i] == p[j]) {
                ++i;
                ++j;
            } else {
                int k = 0;
                for (; k < mappings.size(); ++k) {
                    if (s[i] == mappings[k][0]) {
                        s[i] = mappings[k][1];
                        break;
                    }
                }
                if (k == mappings.size()) {
                    mappings.push_back({s[i], p[j]});
                    ++i;
                    ++j;
                }
            }
        }
        return i == n && j == m && matchReplacement(s, p, mappings) && isSubsequence(p, s);
    }
};