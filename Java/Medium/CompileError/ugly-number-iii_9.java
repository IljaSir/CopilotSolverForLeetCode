class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long l = 1, r = (long) 2 * 1e9;
        while (l < r) {
            long mid = l + r >> 1;
            if (count(mid, a, b, c) < n) l = mid + 1;
            else r = mid;
        }
        return (int) l;
    }
    long count(long x, int a, int b, int c) {
        return x / a + x / b + x / c - x / lcm(a, b) - x / lcm(a, c) - x / lcm(b, c) + x / lcm(a, lcm(b, c));
    }
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}