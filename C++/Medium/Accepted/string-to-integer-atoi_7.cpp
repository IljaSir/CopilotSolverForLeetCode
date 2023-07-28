class Solution {
public:
    int myAtoi(string s) {
        
        int i = 0;
        int n = s.length();
        while (i < n && s[i] == ' ') {
            ++i;
        }
        if (i >= n) {
            return 0;
        }
        bool isNegative = false;
        if (s[i] == '-') {
            isNegative = true;
            ++i;
        } else if (s[i] == '+') {
            ++i;
        }
        int64_t result = 0;
        while (i < n && isdigit(s[i])) {
            result = result * 10 + s[i] - '0';
            if (result > INT_MAX) {
                break;
            }
            ++i;
        }
        if (isNegative) {
            result = -result;
        }
        if (result > INT_MAX) {
            return INT_MAX;
        }
        if (result < INT_MIN) {
            return INT_MIN;
        }
        return result;
    }
};