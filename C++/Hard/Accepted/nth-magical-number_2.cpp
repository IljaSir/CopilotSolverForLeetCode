class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        if (a > b) swap(a, b);
        int64_t l = 0, r = 1e15;
        while (l < r) {
            int64_t m = (l + r) / 2;
            if (m / a + m / b - m / lcm(a, b) < n) l = m + 1;
            else r = m;
        }
        return l % (int)(1e9 + 7);
    }
    int64_t gcd(int64_t a, int64_t b) {
        return b == 0 ? a : gcd(b, a % b);
    }
};