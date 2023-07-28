class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        int64_t l = stoll(left), r = stoll(right);
        int64_t lo = sqrt(l), hi = sqrt(r);
        int64_t ans = 0;
        for (int64_t i = lo; i <= hi; ++i) {
            int64_t p = i;
            for (int64_t j = i / 10; j > 0; j /= 10) {
                p = p * 10 + j % 10;
            }
            p *= p;
            if (p >= l && p <= r && isPalindromic(p)) {
                ++ans;
            }
        }
        for (int64_t i = lo; i <= hi; ++i) {
            int64_t p = i;
            for (int64_t j = i; j > 0; j /= 10) {
                p = p * 10 + j % 10;
            }
            p *= p;
            if (p >= l && p <= r && isPalindromic(p)) {
                ++ans;
            }
        }
        return ans;
    }
    bool isPalindromic(int64_t n) {
        int64_t m = 0;
        for (int64_t i = n; i > 0; i /= 10) {
            m = m * 10 + i % 10;
        }
        return n == m;
    }
};