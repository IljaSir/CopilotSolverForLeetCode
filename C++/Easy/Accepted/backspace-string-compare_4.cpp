class Solution {
public:
    bool backspaceCompare(string s, string t) {
        
        int i = s.size() - 1, j = t.size() - 1;
        int skipi = 0, skipj = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s[i] == '#') {
                    skipi++;
                    i--;
                } else if (skipi > 0) {
                    skipi--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t[j] == '#') {
                    skipj++;
                    j--;
                } else if (skipj > 0) {
                    skipj--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && s[i] != t[j]) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
};