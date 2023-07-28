class Solution {
    public int countGoodNumbers(long n) {
        
        long res = 1;
        long mod = (long)Math.pow(10, 9) + 7;
        long a = n / 2;
        long b = n - a;
        res = res * (long)Math.pow(5, a) % mod;
        res = res * (long)Math.pow(4, b) % mod;
        return (int)res;
    }
}