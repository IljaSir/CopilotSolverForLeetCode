class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        unordered_map<char, string> m;
        unordered_map<string, char> m2;
        int i = 0;
        int j = 0;
        for (int k = 0; k < pattern.size(); k++) {
            while (s[j] != ' ' && j < s.size()) {
                j++;
            }
            string str = s.substr(i, j - i);
            if (m.find(pattern[k]) != m.end() && m[pattern[k]] != str) {
                return false;
            }
            if (m2.find(str) != m2.end() && m2[str] != pattern[k]) {
                return false;
            }
            m[pattern[k]] = str;
            m2[str] = pattern[k];
            i = j + 1;
            j = i;
        }
        return true;
    }
};