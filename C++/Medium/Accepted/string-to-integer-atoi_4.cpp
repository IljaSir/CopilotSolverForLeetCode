class Solution {
public:
    int myAtoi(string s) {
        
        int i = 0, n = s.size();
        while (i < n && s[i] == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n) {
            if (s[i] == '-') {
                sign = -1;
                i++;
            } else if (s[i] == '+') {
                sign = 1;
                i++;
            }
        }
        long long res = 0;
        while (i < n && isdigit(s[i])) {
            res = res * 10 + s[i] - '0';
            i++;
            if (sign == 1 && res > INT_MAX) {
                return INT_MAX;
            }
            if (sign == -1 && -res < INT_MIN) {
                return INT_MIN;
            }
        }
        return res * sign;
    }
};