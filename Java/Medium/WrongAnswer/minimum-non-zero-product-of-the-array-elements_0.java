class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = (long)1e9 + 7;
        long n = (long)Math.pow(2, p) - 1;
        long m = (n - 1) / 2;
        long a = (long)Math.pow(2, p - 1) - 1;
        long b = (long)Math.pow(2, p) - 1;
        long c = (long)Math.pow(2, p - 1);
        long ans = (long)Math.pow(2, p - 1) * (long)Math.pow(2, p) - 1;
        long res = (long)pow(a, m, mod) * (long)pow(b, m, mod) % mod;
        return (int)(ans * res % mod);
    }
    private long pow(long x, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }
}