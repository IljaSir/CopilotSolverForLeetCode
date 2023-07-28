class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int b = 2; b < n; ++b) {
            int x = n;
            string s;
            while (x) {
                s += '0' + x % b;
                x /= b;
            }
            int i = 0, j = s.size() - 1;
            while (i < j) {
                if (s[i] != s[j]) return false;
                ++i; --j;
            }
        }
        return true;
    }
};