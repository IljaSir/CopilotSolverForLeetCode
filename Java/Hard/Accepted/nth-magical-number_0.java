class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int MOD = 1000000007;
        long lcm = (long) a * b / gcd(a, b);
        long lo = 0;
        long hi = (long) Math.min(a, b) * n;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi / a + mi / b - mi / lcm < n) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return (int) (lo % MOD);
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}