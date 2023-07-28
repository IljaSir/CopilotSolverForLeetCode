class Solution {
public:
    int myAtoi(string s) {
        
        int i = 0;
        int sign = 1;
        int res = 0;
        while (s[i] == ' ') {
            i++;
        }
        if (s[i] == '-') {
            sign = -1;
            i++;
        } else if (s[i] == '+') {
            i++;
        }
        while (s[i] >= '0' && s[i] <= '9') {
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && s[i] - '0' > INT_MAX % 10)) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            res = res * 10 + s[i] - '0';
            i++;
        }
        return sign * res;
    }
};