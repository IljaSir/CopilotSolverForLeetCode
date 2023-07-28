class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        int i;
        for (i = 2; i <= n - 2; i++) {
            if (!isPalindromic(n, i)) {
                return false;
            }
        }
        return true;
    }
    bool isPalindromic(int n, int b) {
        string s;
        while (n) {
            s += (n % b) + '0';
            n /= b;
        }
        int i, j;
        for (i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
};