class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long l = 1;
        long r = (long)2e9;
        while (l < r) {
            long m = (l + r) >> 1;
            if (count(m, a, b, c) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (int)l;
    }
    
    long count(long n, int a, int b, int c) {
        return n / a + n / b + n / c - n / lcm(a, b) - n / lcm(b, c) - n / lcm(a, c) + n / lcm(a, lcm(b, c));
    }
    
    long lcm(int a, int b) {
        return (long)a * b / gcd(a, b);
    }
}