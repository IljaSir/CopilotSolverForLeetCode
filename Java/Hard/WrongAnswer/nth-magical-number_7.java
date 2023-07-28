class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1000000007;
        int gcd = gcd(a, b);
        int lcm = a * b / gcd;
        int l = 2;
        int r = Math.min(a, b) * n;
        int res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int count = m / a + m / b - m / lcm;
            if (count >= n) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res % mod;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}