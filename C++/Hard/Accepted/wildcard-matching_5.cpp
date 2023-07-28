class Solution {
public:
    bool isMatch(string s, string p) {
        
        int i = 0, j = 0, match = 0, startIdx = -1;
        while (i < s.length()) {
            if (j < p.length() && (p[j] == '?' || p[j] == s[i])) {
                i++;
                j++;
            } else if (j < p.length() && p[j] == '*') {
                startIdx = j;
                match = i;
                j++;
            } else if (startIdx != -1) {
                j = startIdx + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < p.length() && p[j] == '*') {
            j++;
        }
        return j == p.length();
    }
};