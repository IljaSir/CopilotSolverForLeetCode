class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        unordered_map<char, string> m;
        unordered_map<string, char> m2;
        int i = 0;
        int j = 0;
        while (i < pattern.size() && j < s.size()) {
            char c = pattern[i];
            string t = "";
            while (j < s.size() && s[j] != ' ') {
                t += s[j++];
            }
            if (m.find(c) == m.end()) {
                m[c] = t;
            } else {
                if (m[c] != t) {
                    return false;
                }
            }
            if (m2.find(t) == m2.end()) {
                m2[t] = c;
            } else {
                if (m2[t] != c) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return i == pattern.size() && j == s.size();
    }
};