class Solution {
public:
    int myAtoi(string s) {
        
        int i = 0;
        int sign = 1;
        int res = 0;
        while (s[i] == ' ') i++;
        if (s[i] == '-') {
            sign = -1;
            i++;
        } else if (s[i] == '+') {
            sign = 1;
            i++;
        }
        while (s[i] >= '0' && s[i] <= '9') {
            int digit = s[i] - '0';
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && digit > INT_MAX % 10)) {
                if (sign == 1) return INT_MAX;
                return INT_MIN;
            }
            res = res * 10 + digit;
            i++;
        }
        return sign * res;
    }
};