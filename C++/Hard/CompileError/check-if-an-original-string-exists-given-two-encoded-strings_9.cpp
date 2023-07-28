class Solution {
public:
    bool possiblyEquals(string s1, string s2) {
        
        if (s1.size() != s2.size()) return false;
        if (s1.size() == 0) return true;
        if (s1[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s1.size(); i++) {
            if (s1.substr(0, i) != s2.substr(0, i)) continue;
            if (possiblyEquals(s1.substr(i), s2.substr(i))) return true;
        }
        return false;
    }
    bool isDecodable(string s1, string s2) {
        if (s1.size() == 0) return true;
        if (s2.size() == 0) return false;
        if (s1[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s1.size(); i++) {
            if (s1.substr(0, i) != s2.substr(0, i)) continue;
            if (isDecodable(s1.substr(i), s2.substr(i))) return true;
        }
        return false;
    }
    bool isDecodable(string s) {
        if (s.size() == 0) return true;
        if (s[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s.size(); i++) {
            if (stoi(s.substr(0, i)) > 26) continue;
            if (isDecodable(s.substr(i))) return true;
        }
        return false;
    }
    bool isDecodable(string s1, string s2) {
        if (s1.size() == 0) return true;
        if (s2.size() == 0) return false;
        if (s1[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s1.size(); i++) {
            if (s1.substr(0, i) != s2.substr(0, i)) continue;
            if (isDecodable(s1.substr(i), s2.substr(i))) return true;
        }
        return false;
    }
};