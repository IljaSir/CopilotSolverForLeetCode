class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        long lcm = lcm(a, b);
        long lo = 0;
        long hi = 1L * n * Math.max(a, b);
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long cnt = mid / a + mid / b - mid / lcm;
            if (cnt < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) (lo % 1000000007);
    }

    long lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}