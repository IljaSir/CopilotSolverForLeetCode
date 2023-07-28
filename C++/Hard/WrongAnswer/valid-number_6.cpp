class Solution {
public:
    bool isNumber(string s) {
        
        int len = s.size();
        int i = 0;
        // skip leading spaces
        while (i < len && s[i] == ' ') {
            i++;
        }
        // skip leading sign
        if (s[i] == '-' || s[i] == '+') {
            i++;
        }
        // skip leading zeros
        while (i < len && s[i] == '0') {
            i++;
        }
        // check numbers
        bool hasNum = false;
        while (i < len && isdigit(s[i])) {
            i++;
            hasNum = true;
        }
        // check dot
        bool hasDot = false;
        if (i < len && s[i] == '.') {
            i++;
            hasDot = true;
            // skip trailing zeros
            while (i < len && s[i] == '0') {
                i++;
            }
            // check numbers
            while (i < len && isdigit(s[i])) {
                i++;
                hasNum = true;
            }
        }
        // check exponent
        if (i < len && (s[i] == 'e' || s[i] == 'E')) {
            i++;
            if (i < len && (s[i] == '-' || s[i] == '+')) {
                i++;
            }
            // check numbers
            bool hasExpNum = false;
            while (i < len && isdigit(s[i])) {
                i++;
                hasExpNum = true;
            }
            if (!hasExpNum) {
                return false;
            }
        }
        // skip trailing spaces
        while (i < len && s[i] == ' ') {
            i++;
        }
        return hasNum && i == len;
    }
};