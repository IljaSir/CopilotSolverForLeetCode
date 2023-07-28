class Solution {
public:
    string decodeAtIndex(string s, int k) {
        
        long long len = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                len++;
            } else {
                len *= (s[i] - '0');
            }
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                if (k % len == 0) {
                    return string(1, s[i]);
                } else {
                    len--;
                }
            } else {
                len /= (s[i] - '0');
                k %= len;
            }
        }
        return "";
    }
};