class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int base = 2; base < n; ++base) {
            long long num = 0;
            int t = n;
            while (t) {
                num = num * base + t % base;
                t /= base;
            }
            if (num != n) return false;
        }
        return true;
    }
};