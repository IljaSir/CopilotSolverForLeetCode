class Solution {
public:
    bool isNumber(string s) {
        
        int n = s.size();
        int i = 0;
        while (s[i] == ' ') {
            ++i;
        }
        if (s[i] == '+' || s[i] == '-') {
            ++i;
        }
        bool num = false;
        bool dot = false;
        bool exp = false;
        while (i < n) {
            if (isdigit(s[i])) {
                num = true;
            } else if (s[i] == '.') {
                if (dot || exp) {
                    return false;
                }
                dot = true;
            } else if (s[i] == 'e' || s[i] == 'E') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (s[i] == '+' || s[i] == '-') {
                if (s[i - 1] != 'e' && s[i - 1] != 'E') {
                    return false;
                }
            } else if (s[i] == ' ') {
                break;
            } else {
                return false;
            }
            ++i;
        }
        while (s[i] == ' ') {
            ++i;
        }
        return num && i == n;
    }
};