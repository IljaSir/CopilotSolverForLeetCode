class Solution {
public:
    int myAtoi(string s) {
        
        int i = 0;
        int n = s.size();
        int sign = 1;
        int res = 0;
        // ignore leading whitespace
        while (i < n && s[i] == ' ') {
            i++;
        }
        // check sign
        if (i < n && (s[i] == '-' || s[i] == '+')) {
            sign = s[i] == '-' ? -1 : 1;
            i++;
        }
        while (i < n && s[i] >= '0' && s[i] <= '9') {
            int digit = s[i] - '0';
            // check overflow
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && digit > 7)) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            res = res * 10 + digit;
            i++;
        }
        return res * sign;
    }
};