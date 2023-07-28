class Solution {
public:
    int myAtoi(string s) {
        
        int i = 0;
        while (i < s.size() && s[i] == ' ') {
            ++i;
        }
        if (i == s.size()) {
            return 0;
        }
        bool isNegative = false;
        if (s[i] == '-') {
            isNegative = true;
            ++i;
        } else if (s[i] == '+') {
            ++i;
        }
        long long res = 0;
        while (i < s.size() && s[i] >= '0' && s[i] <= '9') {
            res = res * 10 + s[i] - '0';
            if (res > INT_MAX) {
                break;
            }
            ++i;
        }
        if (isNegative) {
            res = -res;
        }
        if (res < INT_MIN) {
            return INT_MIN;
        }
        if (res > INT_MAX) {
            return INT_MAX;
        }
        return res;
    }
};