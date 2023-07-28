class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int b = 2; b < n - 1; ++b) {
            int x = n;
            string s;
            while (x) {
                s += (x % b) + '0';
                x /= b;
            }
            int i = 0, j = s.size() - 1;
            while (i < j) {
                if (s[i] != s[j]) {
                    break;
                }
                ++i, --j;
            }
            if (i < j) {
                return false;
            }
        }
        return true;
    }
};