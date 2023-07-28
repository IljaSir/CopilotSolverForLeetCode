class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        int a = n;
        int b = 0;
        while (a > 0) {
            b = b * 10 + a % 10;
            a /= 10;
        }
        if (b != n) return false;
        for (int i = 2; i < n - 2; ++i) {
            a = n;
            b = 0;
            while (a > 0) {
                b = b * i + a % i;
                a /= i;
            }
            a = n;
            while (a > 0) {
                if (a % i != b % i) return false;
                a /= i;
                b /= i;
            }
        }
        return true;
    }
};