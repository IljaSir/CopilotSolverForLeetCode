class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        int64_t ab = (int64_t)a * b / gcd(a, b);
        int64_t ac = (int64_t)a * c / gcd(a, c);
        int64_t bc = (int64_t)b * c / gcd(b, c);
        int64_t abc = (int64_t)ab * c / gcd(ab, c);
        int64_t l = 1, r = 2 * 1e9;
        while (l < r) {
            int64_t m = (l + r) >> 1;
            int64_t cnt = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if (cnt < n) l = m + 1;
            else r = m;
        }
        return l;
    }
};