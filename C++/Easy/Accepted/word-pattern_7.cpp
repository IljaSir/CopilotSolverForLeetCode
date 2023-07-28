class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        vector<string> strs;
        istringstream iss(s);
        string str;
        while (iss >> str) {
            strs.push_back(str);
        }
        if (pattern.length() != strs.size()) return false;
        unordered_map<char, string> m;
        for (int i = 0; i < pattern.length(); i++) {
            if (m.find(pattern[i]) == m.end()) {
                m[pattern[i]] = strs[i];
            } else {
                if (m[pattern[i]] != strs[i]) return false;
            }
        }
        unordered_map<string, char> m2;
        for (int i = 0; i < pattern.length(); i++) {
            if (m2.find(strs[i]) == m2.end()) {
                m2[strs[i]] = pattern[i];
            } else {
                if (m2[strs[i]] != pattern[i]) return false;
            }
        }
        return true;
    }
};