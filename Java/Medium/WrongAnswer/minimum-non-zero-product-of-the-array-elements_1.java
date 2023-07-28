class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = (long)1e9 + 7;
        long n = (long) Math.pow(2, p) - 1;
        long ans = (long) Math.pow(2, p - 1) - 1;
        ans = ans * (long) Math.pow(2, p - 1) % mod;
        ans = ans * pow(n - 1, n / 2 - 1, mod) % mod;
        return (int) ans;
    }
    public long pow(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }
}