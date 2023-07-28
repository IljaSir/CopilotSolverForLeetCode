class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        if (n == 1) return 1;
        int l = 1, r = 2e9;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (count(m, a, b, c) >= n) r = m;
            else l = m + 1;
        }
        return l;
    }
    long count(long x, long a, long b, long c) {
        return x / a + x / b + x / c - x / lcm(a, b) - x / lcm(b, c) - x / lcm(a, c) + x / lcm(a, lcm(b, c));
    }
};