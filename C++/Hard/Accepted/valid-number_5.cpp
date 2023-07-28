class Solution {
public:
    bool isNumber(string s) {
        
        int i = 0;
        int len = s.length();
        // skip whitespace
        while (i < len && s[i] == ' ') {
            i++;
        }
        // skip sign
        if (i < len && (s[i] == '+' || s[i] == '-')) {
            i++;
        }
        // check digits
        bool isDigit = false;
        while (i < len && isdigit(s[i])) {
            i++;
            isDigit = true;
        }
        // check dot
        if (i < len && s[i] == '.') {
            i++;
            while (i < len && isdigit(s[i])) {
                i++;
                isDigit = true;
            }
        }
        // check e
        if (isDigit && i < len && (s[i] == 'e' || s[i] == 'E')) {
            i++;
            isDigit = false;
            if (i < len && (s[i] == '+' || s[i] == '-')) {
                i++;
            }
            while (i < len && isdigit(s[i])) {
                i++;
                isDigit = true;
            }
        }
        // skip whitespace
        while (i < len && s[i] == ' ') {
            i++;
        }
        return isDigit && i == len;
    }
};