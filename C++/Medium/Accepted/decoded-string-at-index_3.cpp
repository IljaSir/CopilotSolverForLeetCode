class Solution {
public:
    string decodeAtIndex(string s, int k) {
        
        long long n = 0;
        int len = s.size();
        for (int i = 0; i < len; i++) {
            if (isdigit(s[i])) {
                n *= s[i] - '0';
            } else {
                n++;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            k %= n;
            if (k == 0 && isalpha(s[i])) {
                return string(1, s[i]);
            }
            if (isdigit(s[i])) {
                n /= s[i] - '0';
            } else {
                n--;
            }
        }
        return "";
    }
};