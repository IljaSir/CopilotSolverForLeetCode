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
        bool neg = false;
        if (s[i] == '-') {
            neg = true;
            i++;
        } else if (s[i] == '+') {
            i++;
        }
        long long ans = 0;
        while (i < n && isdigit(s[i])) {
            ans = ans * 10 + s[i] - '0';
            if (ans > INT_MAX) {
                break;
            }
            i++;
        }
        if (neg) {
            ans = -ans;
        }
        if (ans < INT_MIN) {
            return INT_MIN;
        }
        if (ans > INT_MAX) {
            return INT_MAX;
        }
        return ans;
    }
};