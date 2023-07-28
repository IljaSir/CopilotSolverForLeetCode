class Solution {
    public int countGoodNumbers(long n) {
        
        long mod = 1000000007;
        long even = n / 2;
        long odd = n - even;
        return (int) ((fastPow(5, even, mod) * fastPow(4, odd, mod)) % mod);
    }
    public long fastPow(long x, long n, long mod) {
        if (n == 0) {
            return 1;
        }
        long half = fastPow(x, n / 2, mod);
        if (n % 2 == 0) {
            return (half * half) % mod;
        }
        return (half * half % mod) * x % mod;
    }
}