class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = 1000000007;
        long n = (1L << p) - 1;
        long ans = (n - 1) % mod;
        long a = n / 2;
        long b = n - a;
        long tmp = 1;
        while (a > 0) {
            if ((a & 1) == 1) {
                tmp *= b;
                tmp %= mod;
            }
            b *= b;
            b %= mod;
            a >>= 1;
        }
        ans *= tmp - 1;
        ans %= mod;
        return (int) ans;
    }
}