class Solution {
    public int countGoodNumbers(long n) {
        
        int mod = 1000000007;
        long even = n / 2;
        long odd = n - even;
        return (int) ((powmod(5, even, mod) * powmod(4, odd, mod)) % mod);
    }
}