class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long l = 1, r = 2000000000, m;
        while (l < r) {
            m = (l + r) / 2;
            if (count(m, a, b, c) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (int) r;
    }
    long count(long x, int a, int b, int c) {
        return x / a + x / b + x / c - x / lcm(a, b) - x / lcm(a, c) - x / lcm(b, c) + x / lcm(a, lcm(b, c));
    }
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}