class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int i = 2; i < n - 1; ++i) {
            int t = n;
            string s;
            while (t) {
                s += '0' + t % i;
                t /= i;
            }
            for (int j = 0; j < s.size() / 2; ++j) {
                if (s[j] != s[s.size() - 1 - j]) {
                    goto next;
                }
            }
            return false;
        next:;
        }
        return true;
    }
};