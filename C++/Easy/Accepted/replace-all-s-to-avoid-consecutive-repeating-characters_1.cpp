class Solution {
public:
    string modifyString(string s) {
        
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if ((i == 0 || s[i - 1] != c) && (i == s.size() - 1 || s[i + 1] != c)) {
                        s[i] = c;
                        break;
                    }
                }
            }
        }
        return s;
    }
};