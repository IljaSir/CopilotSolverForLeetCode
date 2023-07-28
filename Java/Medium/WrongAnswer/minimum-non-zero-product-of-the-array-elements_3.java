class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = 1000000007;
        long n = (1L << p) - 1;
        long ans = (n - 1) % mod;
        long half = (n / 2) % mod;
        ans = ans * modPow(half, n - 2, mod) % mod;
        return (int) ans;
    }

    public long modPow(long x, long n, long mod) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ans;
    }
}