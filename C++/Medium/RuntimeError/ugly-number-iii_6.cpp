class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        int64_t l = 1, r = 2 * 1000000000;
        int64_t ab = lcm(a, b);
        int64_t bc = lcm(b, c);
        int64_t ac = lcm(a, c);
        int64_t abc = lcm(ab, c);
        while (l < r) {
            int64_t m = l + (r - l) / 2;
            int64_t cnt = m / a + m / b + m / c - m / ab - m / bc - m / ac + m / abc;
            if (cnt < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    
    int64_t gcd(int64_t a, int64_t b) {
        return b == 0 ? a : gcd(b, a % b);
    }
};