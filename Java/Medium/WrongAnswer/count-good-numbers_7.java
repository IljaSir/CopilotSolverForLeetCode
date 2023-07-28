class Solution {
    public int countGoodNumbers(long n) {
        
        long res = 1;
        long mod = 1000000007;
        long even = n/2;
        long odd = n - even;
        res = res * pow(5, even, mod) % mod;
        res = res * pow(4, odd, mod) % mod;
        return (int)res;
    }
    
    public long pow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}