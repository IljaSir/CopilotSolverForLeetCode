class Solution {
public:
    bool isMatch(string s, string p) {
        
        if (p.empty()) return s.empty();
        if (p[1] == '*') {
            return isMatch(s, p.substr(2)) || (!s.empty() && (p[0] == '.' || p[0] == s[0]) && isMatch(s.substr(1), p));
        } else {
            return !s.empty() && (p[0] == '.' || p[0] == s[0]) && isMatch(s.substr(1), p.substr(1));
        }
    }
};