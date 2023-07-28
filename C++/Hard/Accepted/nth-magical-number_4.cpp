class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int64_t mod = 1e9 + 7;
        int64_t l = 1, r = 1e15;
        int64_t ans = 0;
        while (l <= r) {
            int64_t m = l + (r - l) / 2;
            int64_t cnt = m / a + m / b - m / lcm(a, b);
            if (cnt >= n) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans % mod;
    }
    int64_t gcd(int64_t a, int64_t b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    int64_t lcm(int64_t a, int64_t b) {
        return a / gcd(a, b) * b;
    }
};