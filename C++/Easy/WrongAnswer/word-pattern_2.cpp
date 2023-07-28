class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        unordered_map<char, string> m1;
        unordered_map<string, char> m2;
        int i = 0;
        for (int j = 0; j <= s.size(); j++) {
            if (j == s.size() || s[j] == ' ') {
                if (m1.find(pattern[i]) != m1.end()) {
                    if (m1[pattern[i]] != s.substr(i, j-i)) return false;
                } else {
                    m1[pattern[i]] = s.substr(i, j-i);
                }
                if (m2.find(s.substr(i, j-i)) != m2.end()) {
                    if (m2[s.substr(i, j-i)] != pattern[i]) return false;
                } else {
                    m2[s.substr(i, j-i)] = pattern[i];
                }
                i = j+1;
            }
        }
        return i == s.size()+1;
    }
};