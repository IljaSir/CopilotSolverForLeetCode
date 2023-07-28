class Solution {
public:
    string decodeAtIndex(string s, int k) {
        
        long long n = 0;
        int i = 0;
        while (n < k) {
            n = isdigit(s[i]) ? n * (s[i] - '0') : n + 1;
            ++i;
        }
        while (i--) {
            if (isdigit(s[i])) {
                n /= s[i] - '0';
                k %= n;
            } else if (k == n || k == 0) {
                return string(1, s[i]);
            } else {
                --n;
            }
        }
        return "";
    }
};