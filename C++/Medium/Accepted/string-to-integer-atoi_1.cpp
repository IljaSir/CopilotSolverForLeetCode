class Solution {
public:
    int myAtoi(string s) {
        
        int n = s.size();
        int i = 0;
        while (i < n && s[i] == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        bool isNegative = false;
        if (s[i] == '-') {
            isNegative = true;
            i++;
        } else if (s[i] == '+') {
            i++;
        }
        int result = 0;
        while (i < n && isdigit(s[i])) {
            int digit = s[i] - '0';
            if (isNegative) {
                if (result < INT_MIN / 10) {
                    return INT_MIN;
                }
                result *= 10;
                if (result < INT_MIN + digit) {
                    return INT_MIN;
                }
                result -= digit;
            } else {
                if (result > INT_MAX / 10) {
                    return INT_MAX;
                }
                result *= 10;
                if (result > INT_MAX - digit) {
                    return INT_MAX;
                }
                result += digit;
            }
            i++;
        }
        return result;
    }
};