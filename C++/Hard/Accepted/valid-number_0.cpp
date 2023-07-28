class Solution {
public:
    bool isNumber(string s) {
        
        int n = s.size();
        int i = 0;
        while (i < n && s[i] == ' ') i++;
        if (i < n && (s[i] == '+' || s[i] == '-')) i++;
        bool isNum = false;
        while (i < n && isdigit(s[i])) {
            i++;
            isNum = true;
        }
        if (i < n && s[i] == '.') {
            i++;
            while (i < n && isdigit(s[i])) {
                i++;
                isNum = true;
            }
        }
        if (isNum && i < n && (s[i] == 'e' || s[i] == 'E')) {
            i++;
            isNum = false;
            if (i < n && (s[i] == '+' || s[i] == '-')) i++;
            while (i < n && isdigit(s[i])) {
                i++;
                isNum = true;
            }
        }
        while (i < n && s[i] == ' ') i++;
        return isNum && i == n;
    }
};