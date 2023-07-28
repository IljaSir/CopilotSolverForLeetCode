class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);
        long l = 1;
        long r = Integer.MAX_VALUE;
        while (l < r) {
            long m = (l + r) / 2;
            long count = m / a + m / b + m / c - m / ab - m / bc - m / ac + m / abc;
            if (count < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (int)l;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}